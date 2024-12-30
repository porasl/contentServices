package com.porasl.contentservices.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.porasl.contentservices.utils.AccessType;
import com.porasl.contentservices.utils.Category;
import com.porasl.contentservices.utils.State;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

@Data
@Document(collection = "posts")
public class Post {
    @Id
    private String id;
    private String title;
    private String content;
    private List<Attachment> attachments;
    private List<Comment> comments;
    private boolean isDeleted;
    private boolean isDisabled;
    private boolean isPrivate;
    private Category category;
    private AccessType accessType;
    private State state;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
    private LocalDateTime eventDate;
    private LocalDateTime memoryDate;
    private Locale locale;
    private String description;
    private String deletedCode;
   
}
