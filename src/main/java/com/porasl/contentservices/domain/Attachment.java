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
@Table(name = "attachment")
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // ✅ This ensures the DB column is named correctly
    private Long id;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createDate;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModified;

    @CreatedBy
    @Column(nullable = false, updatable = false)
    private Integer createdBy;

    @LastModifiedBy
    @Column(insertable = false)
    private Integer lastModifiedBy;

    @Column(nullable = false)
    private long iteminfoid;

    private String videoPath;
    private String audioPath;
    private String imagePath;
    private String filePath;
    private String type;

    @Column(nullable = false)
    private Long postid;
}
