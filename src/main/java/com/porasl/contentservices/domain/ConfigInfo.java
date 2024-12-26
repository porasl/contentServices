package com.porasl.contentservices.domain;

import javax.persistence.Cacheable;
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
@Table(name = "configinfo")
public class ConfigInfo {
	private long configinfoid;
	
	@Column(nullable=true)
	private String configName;
	
	@Column(nullable=true)
	private String configValue;
	
	@Id
	@Column(name="configinfoid")
	@TableGenerator(name="configinfo", table="Config_Pktb", 
	pkColumnName="configKey", pkColumnValue="configValue", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="configinfo")
	
	public long getConfiginfoid() {
		return configinfoid;
	}
	
	public void setConfiginfoid(long configinfoid) {
		this.configinfoid = configinfoid;
	}
		
	public String getConfigName() {
		return configName;
	}
	
	public void setConfigName(String configName) {
		this.configName = configName;
	}
	
	public String getConfigValue() {
		return configValue;
	}
	
	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}
	
}
