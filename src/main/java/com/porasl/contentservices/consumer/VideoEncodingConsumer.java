package com.porasl.contentservices.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class VideoEncodingConsumer {

    @KafkaListener(topics = "video-uploads", groupId = "video-encoder")
    public void consume(String messageJson) {
        System.out.println("Received message: " + messageJson);

        // Parse JSON and extract filePath
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(messageJson);
            String filePath = node.get("videoTranscode") != null ? node.get("videoTranscode").asText(): null;

           VideoTranscoder transcoder = new VideoTranscoder(filePath);
           transcoder.transcode();
           
            System.out.println("Encoding complete for: " + filePath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
