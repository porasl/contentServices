package com.porasl.contentservices.service;

import java.util.concurrent.TimeUnit;

public class FFMPGServiceImpl implements FfmpegService {
 
	public boolean convertorAnimation(String inputFileAddress, String outputFolder, String ffmpegExe) {
	
		String name = outputFolder +"/videoImage";
		String paletteFile = name + ".png";
		String gifFile = name + ".gif";
		boolean isComplete = false;
		// Operate ffmpeg to generate gif pictures
		for (int i = 0; i < 5; i++){
			try {
				// Generate palette
				Process p = new ProcessBuilder().command(ffmpegExe, "-v", "warning", "-ss",
						"2", "-t", "10", "-i", inputFileAddress, "-vf", "fps=5,scale=400:-1:flags=lanczos,palettegen",
						"-y", paletteFile, "-vn").start();
				isComplete = p.waitFor(10, TimeUnit.SECONDS);

				if (!isComplete) {
					System.out.println("Error generating palette");
				} else {
					p = new ProcessBuilder()
							.command(ffmpegExe, "-v", "warning", "-ss", "2", "-t", "10",
									"-i", inputFileAddress, "-i", paletteFile, "-lavfi",
									"fps=5,scale=650:-1:flags=lanczos [x]; [x][1:v] paletteuse", "-y", gifFile, "-vn").start();
					isComplete = p.waitFor(10, TimeUnit.SECONDS);
					if (isComplete) {
						System.out.println("Generate gif successfully");
						//TODO: Update 
						break;
					} else {
						//update failed transcoded table using etorAnimation(String inputFileAddress, String outputFolder, String ffmpegExe) by a daemon thread
						System.out.println("Error generating gif");
					}
				}
			} catch (Exception e) {
				System.out.println("Error generating gif");
			}
		}
		return true;
	}
	
	
	public boolean genThumbnail(String inputFileAddress, String outputFolder, String ffmpegExe) {
		boolean isComplete = false;
		Process p = null;
		try {
			p = new ProcessBuilder().command(ffmpegExe, "-i", inputFileAddress, "-ss", "00:00:03", "-frames:v", "1", outputFolder+"/thumbnail.jpg").start();
			isComplete = p.waitFor(10, TimeUnit.SECONDS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//ffmpeg -i input.mp4 -vf "select=gte(n\,10)" -vframes 1 thumbnail.jpg
		
		return true;
		
	}
 
 }
