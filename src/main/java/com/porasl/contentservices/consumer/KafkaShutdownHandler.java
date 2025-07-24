package com.porasl.contentservices.consumer;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.stereotype.Component;

@Component
public class KafkaShutdownHandler {

    @Autowired
    private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;

    @PostConstruct
    public void attachShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            kafkaListenerEndpointRegistry.stop();
        }));
    }
}
