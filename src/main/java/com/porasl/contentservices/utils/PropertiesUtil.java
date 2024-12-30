package com.porasl.contentservices.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class  PropertiesUtil {
	static String inrik_properties = "/Users/hamid/tomcat/webapps/inrik.properties";  // Update this

	public static Properties readProperies() {
		Properties prop = new Properties();
		try{
			InputStream in = 
					new FileInputStream(inrik_properties);
				prop.load(in);
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
    return prop;
	}
	
	public static String getServerLogAddress() {
		return readProperies().getProperty("serverLog");
	}
	
	public static String getImagedir() {
		return readProperies().getProperty("imagedir");
	}
	
	public static String getVideodir() {
		return readProperies().getProperty("videodir");
	}
	
	
	public static String getAudiodir() {
		return readProperies().getProperty("audiodir");
	}
	
}
