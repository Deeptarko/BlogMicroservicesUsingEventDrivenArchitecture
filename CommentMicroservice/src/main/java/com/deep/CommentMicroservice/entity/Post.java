//package com.deep.CommentMicroservice.entity;
//
//import java.io.Serializable;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Table(name="post_tbl")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class Post implements Serializable {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	public Long id;
//	public String body;
//	@OneToMany(mappedBy = "post",fetch = FetchType.LAZY,cascade=CascadeType.ALL)
//	private List<Comment>comments;
//	
//}
