package com.porasl.contentservices.domain;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "useractivities")
public class UserActivityI {

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

	private long useractivityinfoid;

	@Column(nullable = true)
	private String action;

	@Column(nullable = true)
	private long visitedChannelid;

	@Column(nullable = true)
	private long userid;

	@Column(nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	public Date creationDate;

	@Id
	@Column(name = "useractivityinfoid")
	@TableGenerator(name = "useractivityinfo", table = "useractivity_Pktb", pkColumnName = "useractivityKey", pkColumnValue = "useractivityValue", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "useractivityinfo")

	public long getUseractivityinfoid() {
		return useractivityinfoid;
	}

	public void setUseractivityinfoid(long useractivityinfoid) {
		this.useractivityinfoid = useractivityinfoid;
	}
}
