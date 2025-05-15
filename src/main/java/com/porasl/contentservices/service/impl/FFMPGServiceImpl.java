package com.porasl.contentservices.service.impl;

import java.util.concurrent.TimeUnit;

import com.porasl.contentservices.service.FFMPGService;

public class FFMPGServiceImpl implements FFMPGService {
 
	public boolean convetorAnimation(String inputFileAddress, String outputFolder, String ffmpegExe) {
	
		String name = outputFolder +"/videoImage";
		String paletteFile = name + ".png";
		String gifFile = name + ".gif";
		boolean isComplete = false;
		// Operate ffmpeg to generate gif pictures
		for (int i = 0; i < 5; i++) {
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
						//update failed trnsscoded table using etorAnimation(String inputFileAddress, String outputFolder, String ffmpegExe) by a daemon thread
						System.out.println("Error generating gif");
					}
				}
			} catch (Exception e) {
				System.out.println("Error generating gif");
			}
		}
		return true;
	}
 
 }

