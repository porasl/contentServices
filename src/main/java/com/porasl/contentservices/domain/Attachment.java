package com.porasl.contentservices.domain;

import java.time.LocalDateTime;

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
@Table(name = "attachment")
public class Attachment {
	private long attachmentid;

	@CreatedDate
	@Column(nullable = false, updatable = false)
	private LocalDateTime createDate;

	@LastModifiedDate
	@Column(insertable = false)
	private LocalDateTime lastModified;

	@CreatedBy
	@Column(nullable = false, updatable = false)
	private Integer createdBy;

	@LastModifiedBy
	@Column(insertable = false)
	private Integer lastModifiedBy;

	@Column(nullable = false)
	private long iteminfoid;

	@Column(nullable = true)
	private String videoPath;

	@Column(nullable = true)
	private String audioPath;

	@Column(nullable = true)
	private String imagePath;

	@Column(nullable = true)
	private String filePath;

	@Column(nullable = true)
	private String type;

	@Column(nullable = false)
	private Long postid;

	@Id
	@Column(name = "attachmentid")
	@TableGenerator(name = "attachment", table = "Attach_Pktb", pkColumnName = "attachKey", pkColumnValue = "attachValue", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "attachment")

	public long getAttachmentid() {
		return attachmentid;
	}

	public void setAttachmentid(long attachmentid) {
		this.attachmentid = attachmentid;
	}

}