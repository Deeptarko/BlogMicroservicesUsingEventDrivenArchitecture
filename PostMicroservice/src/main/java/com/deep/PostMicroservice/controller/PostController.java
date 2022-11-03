package com.deep.PostMicroservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.deep.PostMicroservice.dto.PostRequestDto;
import com.deep.PostMicroservice.dto.PostResponseDto;
import com.deep.PostMicroservice.service.PostService;
import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PostController {
	
	private final PostService postService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String>savePost(@RequestBody PostRequestDto postRequest){
		String result=postService.savePost(postRequest);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<PostResponseDto>>getAllPosts(){
		return ResponseEntity.ok(postService.getAllPosts());
	}
	
	@DeleteMapping("/{postId}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponseEntity<String>deletePost(@PathVariable Long postId){
		String result=postService.deletePost(postId);
		return ResponseEntity.ok(result);
	}
	
	
}
