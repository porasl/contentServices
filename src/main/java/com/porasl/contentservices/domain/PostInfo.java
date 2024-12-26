package com.porasl.contentservices.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
//@Cacheable
//@org.hibernate.annotations.Cache(usage =  org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "postinfo")
public class PostInfo {
	
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
	
	
	public void setUserid(Long userid)
	{
		this.userid = userid;
	}
	
	
	public Long getUserid()
	{
		return userid;
	}
	
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
	
	public String getPublicAccessType(){
	  return publicAccessType;
	}
	
	public void setPublicAccessType(String publicAccessType){
		 this.publicAccessType = publicAccessType;
	}
	
	public boolean getDeleted(){
		  return deleted;
		}
		
	public void setDeleted(boolean deleted){
			 this.deleted = deleted;
		}
	
	public int getDeletecode(){
		  return deletecode;
		}
		
	public void setDeletecode(int deletecode){
			 this.deletecode = deletecode;
		}
	
	public String getState(){
		  return state;
		}
		
	public void setState(String state){
			 this.state = state;
		}
	
	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDeletionDate() {
		return deletionDate;
	}

	public void setDeletionDate(Date deletionDate) {
		this.deletionDate = deletionDate;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	
	public Date getMemoryDate() {
		return memoryDate;
	}

	public void setMemoryDate(Date memoryDate) {
		this.memoryDate = memoryDate;
	}
	
	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}
	

	public boolean isAd() {
		return ad;
	}

	public void setAd(boolean ad) {
		this.ad = ad;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getWatermark() {
		return watermark;
	}
	
	public void setWatermark(String watermark) {
		this.watermark = watermark;
	}
	
	public void setSecureCode(String secureCode) {
		this.secureCode = secureCode;
	}
	
	public String getSecureCode() {
		return secureCode;
	}
}
