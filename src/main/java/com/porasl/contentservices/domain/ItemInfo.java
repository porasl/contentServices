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
@Table(name = "iteminfo")
public class ItemInfo {
	
	private long iteminfoid;

	@Column(nullable=true)
	private String type;
	
	@Column(nullable=true)
	private String oldfilename;
	
	@Column(nullable=true)
	private String hashtags;
	
	@Column(nullable=true)
	private boolean accesstype;
	
	@Column(nullable=true)
	private boolean deleted;
	
	@Column(nullable=true)
	private int deletecode;
	
	@Column(nullable=true)
	private String description;
	
	@Column(nullable=true)
	private String format;
	
	@Column(nullable=true)
	private String audioPath;
	
	@Column(nullable=true)
	private String imagePath;
	
	@Column(nullable=true)
	private String videoPath;
	
	@Column(nullable=true)
	private String filePath;
	
	@Column(nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	public Date creationDate;
	
	@Column(nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificationDate;

	@Column(nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date expirationDate;
	
	@Column(nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date deletionDate;

	@Column(nullable=true)
	private Long userid;
	
	@Column(nullable=true)
	private String commentIds;
	
	@Column(nullable=true)
	private boolean hlsTranscoded;
	
	@Column(nullable=true)
	private boolean imageTranscoded;
	
	@Column(nullable=true)
	private boolean completed;
	
	@Column(nullable=true)
	private boolean featured;
	
	@Column(nullable=true)
	private String locale;
	
	@Id
	@Column(name="iteminfoid")
	@TableGenerator(name="iteminfo", table="Item_Pktb", 
	pkColumnName="itemKey", pkColumnValue="itemValue", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="iteminfo")
	public long getIteminfoid() {
		return iteminfoid;
	}
	
	public void setIteminfoid(long iteminfoid) {
		this.iteminfoid = iteminfoid;
	}
	
	
	public void setUserid(Long userid){
		this.userid = userid;
	}
	
	public Long getUserid(){
		return userid;
	}
	
	public boolean getAccesstype(){
	  return accesstype;
	}
	
	public void setAccesstype(boolean accesstype){
		 this.accesstype = accesstype;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getOldfilename() {
		return oldfilename;
	}

	public void setOldfilename(String oldfilename) {
		this.oldfilename = oldfilename;
	}


	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getAudioPath() {
		return audioPath;
	}

	public void setAudioPath(String audioPath) {
		this.audioPath = audioPath;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getHashtags() {
		return hashtags;
	}
	
	public void setHashtags(String hashtags) {
		this.hashtags = hashtags;
	}

	public String getVideoPath() {
		return videoPath;
	}

	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
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
	
	public String getCommentIds() {
		return commentIds;
	}

	public void setCommentIds(String commentIds) {
		this.commentIds = commentIds;
	}

	public boolean isHlsTranscoded() {
		return hlsTranscoded;
	}

	public void setHlsTranscoded(boolean hlsTranscoded) {
		this.hlsTranscoded = hlsTranscoded;
	}

	public boolean isImageTranscoded() {
		return imageTranscoded;
	}
	
	public void setImageTranscoded(boolean imageTranscoded) {
		this.imageTranscoded = imageTranscoded;
	}
	

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public boolean isFeatured() {
		return featured;
	}

	public void setFeatured(boolean featured) {
		this.featured = featured;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}


}
