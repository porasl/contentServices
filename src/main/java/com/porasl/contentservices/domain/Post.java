package com.porasl.contentservices.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.mongodb.core.mapping.Document;

import com.porasl.contentservices.utils.AccessType;
import com.porasl.contentservices.utils.Category;
import com.porasl.contentservices.utils.State;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

@Document(collection = "posts")
public class Post {
    
    @Id
    private Long postid; // must match the type in MongoRepository
}
