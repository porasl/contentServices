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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
@Table(name = "post")
public class Relational_Post {
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
	
	private long postid;
   
    @Column(nullable=true)
	private long userid;
    
    @Column(nullable=false)
   	private boolean ad;
    
    @Column(nullable=true)
   	private String title;
    
    @Column(nullable=true)
   	private String watermark;
	
	@Column(nullable=true)
	private String locale;
	
	@Column(nullable=true)
	private String description;
	
	@Column(nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date expirationdate;
	
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date creationdate;

	@Column(nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificationdate;
	
	@Column(nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date deletiondate;
	
	@Column(nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date eventdate;
	
	@Column(nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date memorydate;
	
	@Column(nullable=false)
	private int deletecode;
	
	@Column(nullable=false)
	private boolean deleted;
	
	@Column(nullable=true)
	private String state;
	
	@Column(nullable=false)
	private String publicaccesstype;
	
	@Column(nullable=true)
	private String securecode;
	
	@Column(nullable=false)
	private int likes;
	
	
	@Id
	@Column(name="postid")
	@TableGenerator(name="post", table="Post_Pktb", 
	pkColumnName="postkey", pkColumnValue="postvalue", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="post")
	public long getPostid() {
		return postid;
	}
	
	public void setPostid(long postid) {
		this.postid = postid;
	}
	

}
