package com.porasl.contentservices.repository;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.porasl.contentservices.domain.Attachment;
import com.porasl.contentservices.domain.Post;

@Repository
public class CustomPostRepositoryImpl implements CustomPostRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void addAttachment(String postId, Attachment attachment) {
        Query query = new Query(Criteria.where("id").is(postId));
        Update update = new Update().addToSet("attachments", attachment);
        mongoTemplate.updateFirst(query, update, Post.class);
    }

    @Override
    public void removeAttachment(String postId, String filename) {
        Query query = new Query(Criteria.where("id").is(postId));
        Update update = new Update().pull("attachments", new Document("filename", filename));
        mongoTemplate.updateFirst(query, update, Post.class);
    }
}
