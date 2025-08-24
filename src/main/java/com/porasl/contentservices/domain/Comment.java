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

	// Explicit getters to ensure compilation without Lombok processing
	public long getItemid() { return itemid; }
	public long getUserid() { return userid; }
	public String getCommenttext() { return commenttext; }
	public Date getCreationdate() { return creationdate; }
	public Date getModificationdate() { return modificationdate; }
	public long getPostinfoid() { return postinfoid; }
	public long getTotalliked() { return totalliked; }
	public long getTotalunliked() { return totalunliked; }

	// Explicit setters to satisfy JPA property access
	public void setCreatedate(LocalDateTime createdate) { this.createdate = createdate; }
	public void setLastmodified(LocalDateTime lastmodified) { this.lastmodified = lastmodified; }
	public void setCreatedby(Integer createdby) { this.createdby = createdby; }
	public void setLastmodifiedby(Integer lastmodifiedby) { this.lastmodifiedby = lastmodifiedby; }
	public void setItemid(long itemid) { this.itemid = itemid; }
	public void setUserid(long userid) { this.userid = userid; }
	public void setCommenttext(String commenttext) { this.commenttext = commenttext; }
	public void setCreationdate(Date creationdate) { this.creationdate = creationdate; }
	public void setModificationdate(Date modificationdate) { this.modificationdate = modificationdate; }
	public void setPostinfoid(long postinfoid) { this.postinfoid = postinfoid; }
	public void setTotalliked(long totalliked) { this.totalliked = totalliked; }
	public void setTotalunliked(long totalunliked) { this.totalunliked = totalunliked; }
	public void setCommenttype(String commenttype) { this.commenttype = commenttype; }
}
