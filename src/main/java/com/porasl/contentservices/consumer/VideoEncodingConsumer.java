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
            String filePath = node.get("filePath").asText();

            // Run ffmpeg command
            ProcessBuilder pb = new ProcessBuilder(
                "ffmpeg", "-i", filePath,
                "-codec: copy", "-start_number", "0", "-hls_time", "10",
                "-hls_list_size", "0", "-f", "hls", filePath + ".m3u8"
            );
            Process process = pb.inheritIO().start();
            process.waitFor();

            System.out.println("Encoding complete for: " + filePath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
