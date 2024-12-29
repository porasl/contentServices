package com.porasl.contentservices.domain;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
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
@Table(name = "comment")
public class Comment {
	@CreatedDate
    @Column(
            nullable = false,
            updatable = false
    )
    private LocalDateTime createDate;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModified;


    @CreatedBy
    @Column(
            nullable = false,
            updatable = false
    )
    private Integer createdBy;

    @LastModifiedBy
    @Column(insertable = false)
    private Integer lastModifiedBy;
	
	@Column(nullable=true)
	private long itemId;
	
	@Column(nullable=true)
	private long userId;
	
	@Column(nullable=true)
	private String commentText;
	
	@Column(nullable=false)
	private Date creationDate;
	
	@Column(nullable=true)
	private Date modificationDate;
	
	@Column(nullable=false)
	private long postinfoid;
	
	@Column(nullable=false)
	private long commentinfoid;
	
	@Column(nullable=false)
	private long totalLiked;
	
	@Column(nullable=false)
	private long totalUnLiked;
	
	@Column(nullable=false)
	private String commentType;
	
	@Id
	@Column(name="commentinfoid")
	@TableGenerator(name="commentinfo", table="comment_Pktb", 
	pkColumnName="commentKey", pkColumnValue="commentValue", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="commentinfo")
	
	public long getCommentinfoid() {
		return commentinfoid;
	}
	
	public void setCommentinfoid(long commentinfoid) {
		this.commentinfoid = commentinfoid;
	}
}
