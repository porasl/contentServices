package com.porasl.contentservices.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.porasl.contentservices.service.ConfigService;

@RestController
@RequestMapping("/api/config")
public class ConfigController {

    @Autowired
    private ConfigService configService;

    @GetMapping("/map")
    public Map<String, String> getConfigMap() {
        return configService.getConfigInfoMap();
    }
}
