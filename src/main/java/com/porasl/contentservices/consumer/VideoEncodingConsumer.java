package com.porasl.contentservices.consumer;

import java.util.concurrent.CompletableFuture;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class VideoEncodingConsumer {
	
    @KafkaListener(topics = "video-uploads", groupId = "video-encoder")
    public void consume(String messageJson, Acknowledgment ack) {
        System.out.println("Received message: " + messageJson);
        CompletableFuture.runAsync(() -> {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(messageJson);
            String filePath = node.get("videoTranscode") != null ? node.get("videoTranscode").asText(): null;

           System.out.println("Encoding started for ********  : " + filePath);
           VideoTranscoder transcoder = new VideoTranscoder(filePath);
           transcoder.transcode();
           
            System.out.println("Encoding complete for ***** : " + filePath);
            ack.acknowledge();
        } catch (Exception e) {
            e.printStackTrace();
        }
        });
  
    }
}
