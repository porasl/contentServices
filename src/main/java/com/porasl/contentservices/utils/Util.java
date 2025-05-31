package com.porasl.contentservices.utils;

import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;

import com.porasl.contentservices.service.ConfigService;

public class Util {
	
	@Autowired
	private static ConfigService configService;

	public static String getFilename(Part part) {
		for (String cd : part.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
				return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE																																																		// fix.
			}
		}
		return null;
	}

	public static String getFormat(String filename) {
		return filename.substring(filename.lastIndexOf(".") + 1, filename.length()).toUpperCase();
	}

	public static boolean isImage(String format) {
		return format.equals("JPG") || format.equals("JPEG") || format.equals("BMP") || format.equals("PNG")
				|| format.equals("GIF");
	}

	public static boolean isOther(String format) {
		return format.equals("DOC") || format.equals("DOCX") || format.equals("TXT") || format.equals("EXCEL")
				|| format.equals("XLSX") || format.equals("PPT") || format.equals("PPTX") || format.equals("PDF");
	}

	public static boolean isMp3(String format) {
		return format.equals("mp3") || format.equals("MP3");
	}

	public static String getParamValue(String paramStr) {
		if (paramStr != null) {
			return paramStr.substring(paramStr.indexOf("=") + 1, paramStr.length());
		}
		return "";
	}
	
	
	
}
