package com.deep.CommentMicroservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentRequestDto {
	
	private long postId;
	private String body;
}
