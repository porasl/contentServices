package com.porasl.contentservices.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component 
@ConfigurationProperties(prefix = "storage")
public class StorageProperties {
	String location ="";
	
   public String getLocation(){
	   return location;
   }
   
   public void setLocation(String location){
	   this.location = location;
   }

}
