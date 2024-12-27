package com.porasl.contentservices.service;

import java.util.HashMap;

public interface TranscoderService{
	
  public boolean  genSmallIcon() throws Exception ;
  
  public HashMap getConfigInfoMap();
  
  public String getInputFilename();

   public void setInputFilename(String inputFilename);

   public String getHlsOutputFolder(String fileString) ;
}
