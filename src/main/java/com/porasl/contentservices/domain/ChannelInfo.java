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


@Entity
//@Cacheable
//@org.hibernate.annotations.Cache(usage =  org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "channelinfo")
public class ChannelInfo {

		private long channelinfoid;
		
		@Column(nullable=false)
		private String iconPath;
		
		@Column(nullable=true)
		private String channelName;
		
		@Column(nullable=false)
		private long userid;
		
		@Column(nullable=false)
		private String category;
		
		@Column(nullable=false)
		private String channelTags;
		
		@Column(nullable=false)
		private String channelHashTags;
		
		@Column(nullable=false)
		private String scope;
		
		@Column(nullable=false)
		private boolean featured;
		
		@Column(nullable=false)
		private boolean active;
		
		@Column(nullable=true)
		@Temporal(TemporalType.TIMESTAMP)
		public Date creationDate;
		
		@Column(nullable=true)
		@Temporal(TemporalType.TIMESTAMP)
		public Date modificationDate;
		
		@Column(nullable=true)
		public long channelView;

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

		public long getChannelView() {
			return channelView;
		}
		
		@Id
		@Column(name="channelinfoid")
		@TableGenerator(name="channelinfo", table="Channel_Pktb", 
		pkColumnName="channelKey", pkColumnValue="channelValue", allocationSize=1)
		@GeneratedValue(strategy=GenerationType.TABLE, generator="channelinfo")
		
		public long getChannelinfoid() {
			return channelinfoid;
		}
		
		public void setChannelinfoid(long channelinfoid) {
			this.channelinfoid = channelinfoid;
		}
		
		public String getIconPath() {
			return iconPath;
		}
		
		public void setIconPath(String iconPath) {
			this.iconPath = iconPath;
		}
		
		public String getChannelName() {
			return channelName;
		}
		
		public void setChannelName(String channelName) {
			this.channelName = channelName;
		}
		
		public String getChannelTags() {
			return channelTags;
		}
		
		public void setChannelTags(String channelTags) {
			this.channelTags = channelTags;
		}
		
		public String getChannelHashTags() {
			return channelHashTags;
		}
		
		public void setChannelHashTags(String channelHashTags) {
			this.channelHashTags = channelHashTags;
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

		
		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}
		
		public long channelView() {
			return channelView;
		}

		public void setChannelView(long channelView) {
			this.channelView = channelView;
		}
		
		public long getUserid() {
			return userid;
		}

		public void setUserid(long userid) {
			this.userid = userid;
		}
}

