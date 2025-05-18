package com.porasl.contentservices.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porasl.contentservices.domain.Config;
import com.porasl.contentservices.repository.ConfigRepository;

@Service
public class ConfigService {

    @Autowired
    private ConfigRepository configRepository;

    public Map<String, String> getConfigInfoMap() {
        List<Config> configInfos = configRepository.findAll();

        return configInfos.stream()
                .collect(Collectors.toMap(Config::getConfigname, Config::getConfigvalue));
    }
}