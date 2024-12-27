package com.porasl.contentservices.service;

import java.util.List;

import com.porasl.contentservices.domain.ConfigInfo;

public interface ConfigService
{
   public ConfigInfo createOrUpdate(ConfigInfo configInfo);
   public List<ConfigInfo> getConfigInfos();
	
}
