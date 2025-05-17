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
	
}
