package com.deep.CommentMicroservice.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.deep.CommentMicroservice.dto.CommentRequestDto;
import com.deep.CommentMicroservice.entity.Comment;
import com.deep.CommentMicroservice.repository.CommentRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/comment")
public class CommentService {
	private final CommentRepository commentRepository;
	
	public String saveComment(CommentRequestDto commentRequest) {
		
		Comment comment=new Comment();
		comment.setBody(commentRequest.getBody());
		comment.setPostId(commentRequest.getPostId());
		Comment savedComment=commentRepository.save(comment);
		log.info("Comment saved with the id {} "+savedComment.getId());
		return "Comment Saved Successfully";
	}
	
	@Transactional
	public String deleteCommentsByProductId(Long postId) {
		commentRepository.deleteByPostId(postId);
		return "Posts Deleted Successfully";
	}
	
	
	
	
}
