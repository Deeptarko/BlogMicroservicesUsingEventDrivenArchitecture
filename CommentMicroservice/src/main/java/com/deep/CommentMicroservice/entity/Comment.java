package com.deep.CommentMicroservice.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="comment_tbl")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment  {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long postId;
	private String body;
	

}
