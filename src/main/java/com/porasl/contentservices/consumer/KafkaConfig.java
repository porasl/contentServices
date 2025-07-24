package com.porasl.contentservices.consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.DefaultErrorHandler;

@Configuration
public class KafkaConfig {

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory(
	        ConsumerFactory<String, String> consumerFactory) {

	    ConcurrentKafkaListenerContainerFactory<String, String> factory =
	            new ConcurrentKafkaListenerContainerFactory<>();
	    factory.setConsumerFactory(consumerFactory);

	    factory.setCommonErrorHandler(new DefaultErrorHandler((record, exception) -> {
	        if (exception instanceof org.apache.kafka.clients.consumer.CommitFailedException) {
	            // Suppress or log
	            System.out.println("Suppressed CommitFailedException: " + exception.getMessage());
	        } else {
	            exception.printStackTrace();
	        }
	    }));

	    return factory;
	}
}