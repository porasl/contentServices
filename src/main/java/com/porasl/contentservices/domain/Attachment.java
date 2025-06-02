package com.porasl.contentservices.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "attechment")
public class Attachment {

    @Id
    @GeneratedValue
    private Long id;
    
    private String videopath;
    private String audiopath;
    private String imagepath;
    private String filepath;
    private String type;
    private String createdby;
    private String lastmodifiedby;
    private String postcode;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdate;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastmodified;

    @Column(nullable = true)
    private Long postid;
}
