package com.porasl.contentservices.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.porasl.contentservices.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>, CustomPostRepository{
	
}