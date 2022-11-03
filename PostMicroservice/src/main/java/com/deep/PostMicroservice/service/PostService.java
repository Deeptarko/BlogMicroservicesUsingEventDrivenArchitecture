package com.deep.PostMicroservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.deep.PostMicroservice.dto.PostRequestDto;
import com.deep.PostMicroservice.dto.PostResponseDto;
import com.deep.PostMicroservice.entity.Post;
import com.deep.PostMicroservice.event.PostDeletedEvent;
import com.deep.PostMicroservice.repository.PostRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

	private final PostRepository postRepository;
	private final KafkaTemplate<String,PostDeletedEvent> kafkaTemplate;
	
	public String savePost(PostRequestDto postRequest) {
		Post post = mapToPost(postRequest);
		Post savedPost = postRepository.save(post);
		log.info("Post with the id {} saved successfully", savedPost.getId());
		return "Post saved Successfully";
	}
	public String deletePost(Long postId) {
		postRepository.deleteById(postId);
		kafkaTemplate.send("PostDeletionTopic",new PostDeletedEvent(postId));
		log.info("Post with the id {} deleted successfully", postId);
		return "Post deleted Successfully";
	}

	public List<PostResponseDto> getAllPosts() {
		List<Post> posts = postRepository.findAll();
		List<PostResponseDto> postResult = posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
		return postResult;
	}

	private Post mapToPost(PostRequestDto postRequest) {
		Post post = new Post();
		post.setBody(postRequest.getBody());
		return post;
	}

	private PostResponseDto mapToDto(Post post) {
		PostResponseDto postDto = new PostResponseDto();
		postDto.setBody(post.getBody());
		return postDto;
	}
}
