package com.porasl.contentservices.service;

import org.springframework.stereotype.Service;

@Service
public interface FfmpegService {
	
	public boolean convertorAnimation(String inputFileAddress, String outputFolder, String ffmpegExe); 
	public boolean genThumbnail(String inputFileAddress, String outputFolder, String ffmpegExe);
}


