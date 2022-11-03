package com.deep.CommentMicroservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.deep.CommentMicroservice.dto.CommentRequestDto;
import com.deep.CommentMicroservice.service.CommentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment")
public class CommentController {

	private final CommentService commentService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> saveString(@RequestBody CommentRequestDto commentRequest) {

		String result = commentService.saveComment(commentRequest);
		return ResponseEntity.ok(result);
	}
	
	@RequestMapping("/{postId}")
	public ResponseEntity<String>deletePostsByPostId(@PathVariable Long postId){
		String result=commentService.deleteCommentsByProductId(postId);
		return ResponseEntity.ok(result);
		
	}
}
