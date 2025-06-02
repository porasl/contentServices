package com.porasl.contentservices.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Document(collection = "posts")
public class Post {
    
    @Id
    private String id;
    
    private String locale;
    private String accessType;
    private boolean deleted;
    private String deletedcode;
    private String state;
    private String description;
    private String eventdate;
    private String memorydate;
    private String createdtime;
    private String updatedtime;
}