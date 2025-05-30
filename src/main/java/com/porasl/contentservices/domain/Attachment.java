package com.porasl.contentservices.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;

import lombok.*;

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

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdate;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastmodified;

    @Column(nullable = false)
    private Long postid;
}
