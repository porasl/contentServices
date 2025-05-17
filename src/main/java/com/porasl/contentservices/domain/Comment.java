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
    private LocalDateTime createdate;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastmodified;


    @CreatedBy
    @Column(
            nullable = false,
            updatable = false
    )
    private Integer createdby;

    @LastModifiedBy
    @Column(insertable = false)
    private Integer lastmodifiedby;
	
	@Column(nullable=true)
	private long itemid;
	
	@Column(nullable=true)
	private long userid;
	
	@Column(nullable=true)
	private String commenttext;
	
	@Column(nullable=false)
	private Date creationdate;
	
	@Column(nullable=true)
	private Date modificationdate;
	
	@Column(nullable=false)
	private long postinfoid;
	
	@Column(nullable=false)
	private long commentinfoid;
	
	@Column(nullable=false)
	private long totalliked;
	
	@Column(nullable=false)
	private long totalunliked;
	
	@Column(nullable=false)
	private String commenttype;
	
	@Id
	@Column(name="commentinfoid")
	@TableGenerator(name="commentinfo", table="comment_Pktb", 
	pkColumnName="commentkey", pkColumnValue="commentvalue", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="commentinfo")
	
	public long getCommentinfoid() {
		return commentinfoid;
	}
	
	public void setCommentinfoid(long commentinfoid) {
		this.commentinfoid = commentinfoid;
	}
}
