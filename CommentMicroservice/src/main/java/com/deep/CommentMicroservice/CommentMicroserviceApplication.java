package com.deep.CommentMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import com.deep.CommentMicroservice.event.PostDeletedEvent;

import lombok.extern.slf4j.Slf4j;



@SpringBootApplication
@Slf4j
public class CommentMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommentMicroserviceApplication.class, args);
	}
	
	@KafkaListener(topics="PostDeletionTopic")
	public void handlePostDeletionTopic(PostDeletedEvent postDeletedEvent) {
		log.info("Delete Comments With the id {}",postDeletedEvent.getPostId());
	}

}
