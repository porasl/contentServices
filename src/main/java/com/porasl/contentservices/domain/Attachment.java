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
    private String postid;

    // Explicit getters to ensure compilation without Lombok processing
    public Long getId() { return id; }
    public String getVideopath() { return videopath; }
    public String getAudiopath() { return audiopath; }
    public String getImagepath() { return imagepath; }
    public String getFilepath() { return filepath; }
    public String getType() { return type; }
    public String getPostid() { return postid; }

    // Explicit setters used by consumers/services
    public void setVideopath(String videopath) { this.videopath = videopath; }
    public void setAudiopath(String audiopath) { this.audiopath = audiopath; }
    public void setImagepath(String imagepath) { this.imagepath = imagepath; }
    public void setFilepath(String filepath) { this.filepath = filepath; }
    public void setType(String type) { this.type = type; }
    public void setCreatedate(LocalDateTime createdate) { this.createdate = createdate; }
    public void setCreatedby(String createdby) { this.createdby = createdby; }
    public void setLastmodifiedby(String lastmodifiedby) { this.lastmodifiedby = lastmodifiedby; }
    public void setPostcode(String postcode) { this.postcode = postcode; }
    public void setLastmodified(LocalDateTime lastmodified) { this.lastmodified = lastmodified; }
    public void setPostid(String postid) { this.postid = postid; }
}
