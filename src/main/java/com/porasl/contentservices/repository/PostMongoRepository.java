package com.porasl.contentservices.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.porasl.contentservices.domain.Post;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostMongoRepository extends MongoRepository<Post, String>, CustomPostRepository {
    // Add custom query methods here if needed, for example:
    List<Post> findByLocale(String locale);

    List<Post> findByDeleted(boolean deleted);

    Optional<Post> findByPostid(String postid); // redundant unless you rename _id to something else
}
