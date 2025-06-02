package com.porasl.contentservices.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.porasl.contentservices.domain.Attachment;
import com.porasl.contentservices.domain.Post;

import java.util.List;
import com.porasl.contentservices.domain.Attachment;
import com.porasl.contentservices.domain.Post;

public interface CustomPostRepository {
    List<Post> searchPosts(String keyword);
    void addAttachment(String postId, Attachment attachment);
    void removeAttachment(String postId, String filename);
}
