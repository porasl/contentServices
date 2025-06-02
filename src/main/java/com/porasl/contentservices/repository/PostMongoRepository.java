package com.porasl.contentservices.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.porasl.contentservices.domain.Post;

public interface PostMongoRepository extends MongoRepository<Post, Long>, CustomPostRepository{
	
}