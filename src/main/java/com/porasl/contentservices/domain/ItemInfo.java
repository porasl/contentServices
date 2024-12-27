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
@Table(name = "iteminfo")
public class ItemInfo {
	
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
	
}
