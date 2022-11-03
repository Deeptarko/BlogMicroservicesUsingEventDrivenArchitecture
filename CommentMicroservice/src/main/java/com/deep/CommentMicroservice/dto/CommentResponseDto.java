package com.deep.CommentMicroservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentResponseDto {
	
	private Long productId;
	private String body;
	
}
