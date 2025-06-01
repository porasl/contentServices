package com.porasl.contentservices.consumer;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.porasl.contentservices.domain.Attachment;
import com.porasl.contentservices.domain.Comment;
import com.porasl.contentservices.domain.Post;
import com.porasl.contentservices.repository.AttachRepository;
import com.porasl.contentservices.utils.AccessType;
import com.porasl.contentservices.utils.Category;
import com.porasl.contentservices.utils.State;
import com.porasl.contentservices.utils.UUIDGenerator;

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
            String postCode = attachNode.get("postCode").asText();
            String type = attachNode.get("type").asText();
            
            Attachment attachment = new Attachment();
            attachment.setType(type);
            switch (type) {
		    case "VIDEO":
		        attachment.setVideopath(attachNode.get("videopath").asText());
		        break;
		    case "AUDIO":
		        type = "AUDIO";
		        attachment.setAudiopath(attachNode.get("audiopath").asText());
		        break;
		    case "IMAGE":
		    		attachment.setAudiopath(attachNode.get("imagepath").asText());
		        break;
		    default:
		    		attachment.setAudiopath(attachNode.get("filepath").asText());
            }
            String userId = attachNode.get("userId").asText();
            String videopath = attachNode.get("videopath").asText();
            
            attachment.setCreatedate(LocalDateTime.now());
            attachment.setCreatedby(userId);
            attachment.setLastmodifiedby(userId);
            attachment.setFilepath(videopath);
            if(!postCode.equals("")) {
            	 postCode = UUIDGenerator.generateUUID();
            	 //Create a post
            	 
            }else {
            	
            }
            attachment.setPostcode(postCode);   
            attachment.setLastmodified(LocalDateTime.now());
            attachment.setType(type);
            
            attachRepo.save(attachment);

            System.out.println("postCode: " + postCode);
            System.out.println("type: " + type);
            System.out.println("userId: " + userId);
            System.out.println("videopath: " + videopath);
           
           
            System.out.println("Encoding complete for: " + node.get("attachMessage").asText());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private Post constructPost(String title,boolean isDeleted, boolean isPrivate, Category category, 
    		AccessType accessType, Locale locale, String description, LocalDateTime eventDate, LocalDateTime memoryDate) {
    	    Post post = new Post();
    	    post.setTitle(title);
    	    post.setDeleted(isDeleted);
    	    post.setIsprivate(isPrivate);
    	    post.setCategory(category);
    	    post.setAccessType(accessType);
    	    post.setCreatedtime(LocalDateTime.now());
    	    post.setUpdatedtime(LocalDateTime.now());
    	    post.setEventdate(eventDate);
    	    post.setMemorydate(memoryDate);
    	    post.setLocale(locale);
    	    post.setDescription(description);
    	    post.setDeletedcode("");
    	    
    	    return post;
    	      
    }
}
