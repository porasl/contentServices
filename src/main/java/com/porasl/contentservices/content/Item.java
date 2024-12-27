package com.porasl.contentservices.content;

import java.util.Date;
import java.util.Locale;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Item {

	private long itemInfoId;
	private double version;	
	private Locale locale;
	private String size;
	private String description;
	private String label;
	private String format;
	private String audioPath;
	private String imagePath;
	private String videoPath;
	private String price;
	private String paidAmount;
	private Date creationDate;
	private Date modificationDate;
	private Date expirationDate;
	private Date deletionDate;
	private PublisherClient publisherClient;
	private StatusClient statusClient;
	private String selectedTemplate;
	private String thumbnail;
	private Long publisherId;
	private String type;
	
	public long getItemInfoId() {
		return itemInfoId;
	}
	public void setItemInfoId(long itemInfoId) {
		this.itemInfoId = itemInfoId;
	}
	public Locale getLocale() {
		return locale;
	}
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
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
	public Date getDeletionDate() {
		return deletionDate;
	}
	public void setDeletionDate(Date deletionDate) {
		this.deletionDate = deletionDate;
	}
	public double getVersion() {
		return version;
	}
	public void setVersion(double version) {
		this.version = version;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getVideoPath() {
		return videoPath;
	}
	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}
	public PublisherClient getPublisherClient() {
		return publisherClient;
	}
	public void setPublisherClient(PublisherClient publisherClient) {
		this.publisherClient = publisherClient;
	}
	public StatusClient getStatusClient() {
		return statusClient;
	}
	public void setStatusClient(StatusClient statusClient) {
		this.statusClient = statusClient;
	}
	public String getSelectedTemplate() {
		return selectedTemplate;
	}
	public void setSelectedTemplate(String selectedTemplate) {
		this.selectedTemplate = selectedTemplate;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	public Long getPublisherId() {
		return publisherId;
	}
	public void setpublisherId(Long publisherId) {
		this.publisherId = publisherId;
	}
	

}
