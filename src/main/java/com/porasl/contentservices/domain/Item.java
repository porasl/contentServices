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
@Table(name = "item")
public class Item {
	
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
	
	private long itemid;

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
	private String audiopath;
	
	@Column(nullable=true)
	private String imagepath;
	
	@Column(nullable=true)
	private String videopath;
	
	@Column(nullable=true)
	private String filepath;
	
	@Column(nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	public Date creationdate;
	
	@Column(nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificationdate;

	@Column(nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date expirationdate;
	
	@Column(nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date deletiondate;

	@Column(nullable=true)
	private Long userid;
	
	@Column(nullable=true)
	private String commentids;
	
	@Column(nullable=true)
	private boolean hlstranscoded;
	
	@Column(nullable=true)
	private boolean imagetranscoded;
	
	@Column(nullable=true)
	private boolean completed;
	
	@Column(nullable=true)
	private boolean featured;
	
	@Column(nullable=true)
	private String locale;
	
	@Id
	@Column(name="itemid")
	@TableGenerator(name="item", table="Item_Pktb", 
	pkColumnName="itemkey", pkColumnValue="itemvalue", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="item")
	public long getItemid() {
		return itemid;
	}
	
	public void setItemid(long itemid) {
		this.itemid = itemid;
	}
	
	// Explicit getters to ensure compilation without Lombok processing
	public String getType() { return type; }
	public String getOldfilename() { return oldfilename; }
	public String getHashtags() { return hashtags; }
	public boolean isAccesstype() { return accesstype; }
	public boolean isDeleted() { return deleted; }
	public int getDeletecode() { return deletecode; }
	public String getDescription() { return description; }
	public String getFormat() { return format; }
	public String getAudiopath() { return audiopath; }
	public String getImagepath() { return imagepath; }
	public String getVideopath() { return videopath; }
	public String getFilepath() { return filepath; }
	public Date getCreationdate() { return creationdate; }
	public Date getModificationdate() { return modificationdate; }
	public Date getExpirationdate() { return expirationdate; }
	public Date getDeletiondate() { return deletiondate; }
	public Long getUserid() { return userid; }
	public String getCommentids() { return commentids; }
	public boolean isHlstranscoded() { return hlstranscoded; }
	public boolean isImagetranscoded() { return imagetranscoded; }
	public boolean isCompleted() { return completed; }
	public boolean isFeatured() { return featured; }
	public String getLocale() { return locale; }

	// Explicit setters to satisfy JPA property access
	public void setCreatedate(LocalDateTime createdate) { this.createdate = createdate; }
	public void setLastmodified(LocalDateTime lastmodified) { this.lastmodified = lastmodified; }
	public void setCreatedby(Integer createdby) { this.createdby = createdby; }
	public void setLastmodifiedby(Integer lastmodifiedby) { this.lastmodifiedby = lastmodifiedby; }
	public void setType(String type) { this.type = type; }
	public void setOldfilename(String oldfilename) { this.oldfilename = oldfilename; }
	public void setHashtags(String hashtags) { this.hashtags = hashtags; }
	public void setAccesstype(boolean accesstype) { this.accesstype = accesstype; }
	public void setDeleted(boolean deleted) { this.deleted = deleted; }
	public void setDeletecode(int deletecode) { this.deletecode = deletecode; }
	public void setDescription(String description) { this.description = description; }
	public void setFormat(String format) { this.format = format; }
	public void setAudiopath(String audiopath) { this.audiopath = audiopath; }
	public void setImagepath(String imagepath) { this.imagepath = imagepath; }
	public void setVideopath(String videopath) { this.videopath = videopath; }
	public void setFilepath(String filepath) { this.filepath = filepath; }
	public void setCreationdate(Date creationdate) { this.creationdate = creationdate; }
	public void setModificationdate(Date modificationdate) { this.modificationdate = modificationdate; }
	public void setExpirationdate(Date expirationdate) { this.expirationdate = expirationdate; }
	public void setDeletiondate(Date deletiondate) { this.deletiondate = deletiondate; }
	public void setUserid(Long userid) { this.userid = userid; }
	public void setCommentids(String commentids) { this.commentids = commentids; }
	public void setHlstranscoded(boolean hlstranscoded) { this.hlstranscoded = hlstranscoded; }
	public void setImagetranscoded(boolean imagetranscoded) { this.imagetranscoded = imagetranscoded; }
	public void setCompleted(boolean completed) { this.completed = completed; }
	public void setFeatured(boolean featured) { this.featured = featured; }
	public void setLocale(String locale) { this.locale = locale; }
}
