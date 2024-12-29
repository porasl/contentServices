package com.porasl.contentservices.service;

import java.util.List;

import com.porasl.contentservices.domain.Config;

public interface ConfigService
{
   public Config createOrUpdate(Config configInfo);
   public List<Config> getConfigInfos();
	
}
