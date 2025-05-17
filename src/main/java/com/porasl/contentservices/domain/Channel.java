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
@Table(name = "channel")
public class Channel {
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

		private long channelinfoid;
		
		@Column(nullable=false)
		private String iconpath;
		
		@Column(nullable=true)
		private String channelname;
		
		@Column(nullable=false)
		private long userid;
		
		@Column(nullable=false)
		private String category;
		
		@Column(nullable=false)
		private String channeltags;
		
		@Column(nullable=false)
		private String channelhashtags;
		
		@Column(nullable=false)
		private String scope;
		
		@Column(nullable=false)
		private boolean featured;
		
		@Column(nullable=false)
		private boolean active;
		
		@Column(nullable=true)
		@Temporal(TemporalType.TIMESTAMP)
		public Date creationdate;
		
		@Column(nullable=true)
		@Temporal(TemporalType.TIMESTAMP)
		public Date modificationdate;
		
		@Column(nullable=true)
		public long channelview;

		@Column(nullable=true)
		public String locale;
		
		public String getLocale() {
			return locale;
		}

		public void setLocale(String locale) {
			this.locale = locale;
		}

		public String getScope() {
			return scope;
		}

		public void setScope(String scope) {
			this.scope = scope;
		}

		public boolean isFeatured() {
			return featured;
		}

		public void setFeatured(boolean featured) {
			this.featured = featured;
		}
		
		public boolean isActive() {
			return active;
		}

		public void setActive(boolean active) {
			this.active = active;
		}

		public long getChannelview() {
			return channelview;
		}
		
		@Id
		@Column(name="channelinfoid")
		@TableGenerator(name="channelinfo", table="Channel_Pktb", 
		pkColumnName="channelkey", pkColumnValue="channelvalue", allocationSize=1)
		@GeneratedValue(strategy=GenerationType.TABLE, generator="channelinfo")
		
		public long getChannelinfoid() {
			return channelinfoid;
		}
		
		public void setChannelinfoid(long channelinfoid) {
			this.channelinfoid = channelinfoid;
		}
}

