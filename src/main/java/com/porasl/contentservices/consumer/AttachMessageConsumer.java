package com.porasl.contentservices.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.porasl.contentservices.domain.Attachment;
import com.porasl.contentservices.repository.AttachRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AttachMessageConsumer {
   
	@Autowired
	AttachRepository attachRepo;
	
    @KafkaListener(topics = "attach-uploads", groupId = "attach-uploads")
    public void consume(String messageJson) {
        System.out.println("Received message: " + messageJson);

        // Parse JSON and extract filePath
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(messageJson);
   
            String innerJson =  node.get("attachMessage").asText(); // this is the inner string

            // Parse the inner JSON string
            JsonNode attachNode = mapper.readTree(innerJson);

            // Now extract fields
            String postId = attachNode.get("postId").asText();
            String type = attachNode.get("type").asText();
            String userId = attachNode.get("userId").asText();
            String videopath = attachNode.get("videopath").asText();
            
            Attachment attachment = new Attachment();
            attachment.setCreatedate(null);
            attachment.setCreatedby(null);
            attachment.setFilepath(videopath);
            attachment.setPostid(null);   //TODO ......

            System.out.println("postId: " + postId);
            System.out.println("type: " + type);
            System.out.println("userId: " + userId);
            System.out.println("videopath: " + videopath);
           
           
            System.out.println("Encoding complete for: " + node.get("attachMessage").asText());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
