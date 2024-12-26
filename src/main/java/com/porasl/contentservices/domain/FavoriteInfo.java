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
@Table(name = "favoriteInfo")
public class FavoriteInfo {
		private long favoriteInfoid;
		
		@Column(nullable=true)
		private long userid;
		
		@Column(nullable=true)
		private long itemInfoId;
		
		@Column(nullable=true)
		private String channelName;
		
		@Column(nullable=true)
		private boolean subscribed;
		
		@Column(nullable=true)
		private boolean liked;
		
		@Id
		@Column(name="favoriteInfo")
		@TableGenerator(name="favoriteInfo", table="favorite_Pktb", 
		pkColumnName="favoriteKey", pkColumnValue="favoriteValue", allocationSize=1)
		@GeneratedValue(strategy=GenerationType.TABLE, generator="favoriteInfo")
		
		public long getFavoriteInfoid() {
			return favoriteInfoid;
		}
		
		public void setFavoriteInfoid(long favoriteInfoid) {
			this.favoriteInfoid = favoriteInfoid;
		}
		
		public long getUserid() {
			return userid;
		}
		
		public void setUserid(long userid) {
			this.userid = userid;
		}
		
		public void setChannelName(String channelName) {
			this.channelName = channelName;
		}
		
		public String getChannelName() {
			return channelName;
		}
		
		public void setSubscribed(boolean subscribed) {
			this.subscribed = subscribed;
		}
		
		
		public boolean isSubbscribed() {
			return subscribed;
		}
		
		public void setLiked(boolean liked) {
			this.liked = liked;
		}
		
		public boolean isLiked() {
			return liked;
		}

}

