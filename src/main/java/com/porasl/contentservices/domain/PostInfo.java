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
@Table(name = "postinfo")
public class PostInfo {
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
	
	private long postinfoid;
   
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
	private Date expirationDate;
	
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date creationDate;

	@Column(nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificationDate;
	
	@Column(nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date deletionDate;
	
	@Column(nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date eventDate;
	
	@Column(nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date memoryDate;
	
	@Column(nullable=false)
	private int deletecode;
	
	@Column(nullable=false)
	private boolean deleted;
	
	@Column(nullable=true)
	private String state;
	
	@Column(nullable=false)
	private String publicAccessType;
	
	@Column(nullable=true)
	private String secureCode;
	
	@Column(nullable=false)
	private int likes;
	
	
	@Id
	@Column(name="postinfoid")
	@TableGenerator(name="postinfo", table="Post_Pktb", 
	pkColumnName="postKey", pkColumnValue="postValue", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="postinfo")
	public long getPostinfoid() {
		return postinfoid;
	}
	
	public void setPostinfoid(long postinfoid) {
		this.postinfoid = postinfoid;
	}
	

}
