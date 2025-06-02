package com.porasl.contentservices.repository;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.porasl.contentservices.domain.Attachment;
import com.porasl.contentservices.domain.Post;

import java.util.List;
import com.porasl.contentservices.domain.Attachment;
import com.porasl.contentservices.domain.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.porasl.contentservices.domain.Attachment;
import com.porasl.contentservices.domain.Post;

@Repository
public class CustomPostRepositoryImpl implements CustomPostRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Post> searchPosts(String keyword) {
        Query query = new Query();
        query.addCriteria(Criteria.where("description").regex(keyword, "i"));
        return mongoTemplate.find(query, Post.class);
    }

    @Override
    public void addAttachment(String postId, Attachment attachment) {
        Query query = new Query(Criteria.where("_id").is(postId));
        Update update = new Update().push("attachments", attachment);
        mongoTemplate.updateFirst(query, update, Post.class);
    }

    @Override
    public void removeAttachment(String postId, String filename) {
        Query query = new Query(Criteria.where("_id").is(postId));
        Update update = new Update().pull("attachments", Query.query(Criteria.where("filename").is(filename)));
        mongoTemplate.updateFirst(query, update, Post.class);
    }
}
