package com.porasl.contentservices.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
//@Cacheable
//@org.hibernate.annotations.Cache(usage =  org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "attachinfo")
public class AttachInfo {
	private long attachinfoid;
	
	@Column(nullable=false)
	private long iteminfoid;
	
	@Column(nullable=true)
	private String videoPath;
	
	@Column(nullable=true)
	private String audioPath;
	
	@Column(nullable=true)
	private String imagePath;
	
	@Column(nullable=true)
	private String filePath;
	
	
	@Column(nullable=true)
	private String type;
	
	@Column(nullable=false)
	private Long postinfoid;
	
	@Id
	@Column(name="attachinfoid")
	@TableGenerator(name="attachinfo", table="Attach_Pktb", 
	pkColumnName="attachKey", pkColumnValue="attachValue", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="attachinfo")
	
	public long getAttachinfoid() {
		return attachinfoid;
	}
	
	public void setAttachinfoid(long attachinfoid) {
		this.attachinfoid = attachinfoid;
	}
	
	public long getIteminfoid() {
		return iteminfoid;
	}
	
	public void setIteminfoid(long iteminfoid) {
		this.iteminfoid = iteminfoid;
	}
	
	public long getPostinfoid() {
		return postinfoid;
	}
	
	public void setPostinfoid(long postinfoid) {
		this.postinfoid = postinfoid;
	}
	
	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}
	
	public String getVideoPath() {
		return videoPath;
	}
	
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public String getImagePath() {
		return imagePath;
	}
	
	public void setAudioPath(String audioPath) {
		this.audioPath = audioPath;
	}
	
	public String getAudioPath() {
		return audioPath;
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public String getFilePath() {
		return filePath;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
}