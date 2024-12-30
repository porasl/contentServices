package com.porasl.contentservices.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.porasl.contentservices.domain.Attachment;
import com.porasl.contentservices.domain.Comment;
import com.porasl.contentservices.domain.Item;
import com.porasl.contentservices.domain.Post;
import com.porasl.contentservices.domain.Profile;
import com.porasl.contentservices.helper.PostClient;

 public class  Converter {
	 private static final Logger logger = LoggerFactory.getLogger(Converter.class);
	 
	 
	 public static JSONArray contacts(List<Profile> profiles){
		 JSONArray jsonArray = new JSONArray();
		 profiles
			.stream()
			.parallel()
			.forEach(profile -> {
				JSONObject obj = new JSONObject();
				try {
					obj.put("photo", profile.getIconName());
					obj.put("fullname", profile.getFullname());
					obj.put("userid", profile.getUserid());
					obj.put("birthDat", profile.getBirthDate());
					obj.put("city", profile.getCity());
					obj.put("country", profile.getCountry());
					obj.put("creationDate", profile.getCreationDate());
					obj.put("education", profile.getEducation());
					obj.put("emailAddress", profile.getEmailaddress());
					obj.put("freeTextProfile", profile.getFreeTextProfile());
					obj.put("hashTags", profile.getHashTags());
					obj.put("modificationDate", profile.getModificationDate());
					obj.put("phonenumber", profile.getPhonenumber());
					obj.put("school", profile.getSchool());
					obj.put("searchKeys", profile.getSearechKeys());
					obj.put("locale", profile.getLocale());
					obj.put("tags", profile.getTags());
					obj.put("subscribeIds", profile.getSubscribedIds());
					obj.put("hideinPublicSearch", profile.isHideInPublicsearch());
					obj.put("workPlace", profile.getWorkplace());
					obj.put("tags", profile.getTags());
					obj.put("title", profile.getTitle());
		
					jsonArray.add(obj);
				} catch (JSONException e) {
				 logger.error("failed to get profiles for the contact list");
				}
			});
			return jsonArray;
	 }
	 
	 
	public static JSONArray itemToString(Item[] items, String contentNames){
		JSONArray jsonArray = new JSONArray();
		for(int i=0;i<items.length;i++){
			JSONObject obj = new JSONObject();
			Item item = items[i];
			try {
				obj.put("itemId", item.getItemid());
				obj.put("type", item.getType());
				obj.put("deleted", item.isDeleted());
				obj.put("deleteCode",item.getDeletecode());
				obj.put("description",item.getDescription());
				obj.put("format",item.getFormat());
				obj.put("oldfilename", item.getOldfilename());
				if(item.getAudioPath() != null) {
					obj.put("audioPath",URLDecoder.decode(item.getAudioPath(), "UTF-8"));
				} else if(item.getImagePath() != null) {
					obj.put("imagePath",URLDecoder.decode(item.getImagePath(), "UTF-8"));
				}else if(item.getVideoPath() != null) {
					obj.put("videoPath",URLDecoder.decode(item.getVideoPath(), "UTF-8"));
				}else if(item.getFilePath() != null) {
					obj.put("filePath",URLDecoder.decode(item.getFilePath(), "UTF-8"));
				}
				obj.put("creationDate",item.getCreationDate());
				obj.put("modificationDate",item.getModificationDate());
				obj.put("expirationDate",item.getExpirationDate());
				obj.put("deletionDate",item.getDeletionDate());
				obj.put("userId",item.getUserid());
				obj.put("contentNames", contentNames);
				jsonArray.add(obj);

			} catch (JSONException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return jsonArray;
	}
	
	public static JSONArray postToString(Post[] posts, String contentNames, List<Attachment> attachments){
		JSONArray jsonArray = new JSONArray();
		for(int i=0;i<posts.length;i++){
			JSONObject obj = new JSONObject();
			Post post = posts[i];
		try {
			obj.put("post", post.getId());
			obj.put("locale",post.getLocale());
			obj.put("accessType", post.getAccessType());
			obj.put("deleted", post.isDeleted());
			obj.put("deleteCode",post.getDeletedCode());
			obj.put("isdeleted",post.isDeleted());
			obj.put("state",post.getState());
			obj.put("description",post.getDescription());
			obj.put("eventDate",post.getEventDate());
			
			//set a component for Attached items
			
			obj.put("attachments", attachmentToString(attachments));
			String description = "";
			if(post.getDescription() == null || post.getDescription() == "null") {
				description = "";
			}else {
				description = post.getDescription();
			}
			obj.put("description", description);
			obj.put("creationDate", post.getCreatedTime());
			obj.put("modificationDate",post.getUpdatedTime());
			obj.put("deletedCode", post.getDeletedCode());
			obj.put("userId", "USER_ID");
			obj.put("contentNames", contentNames);
			jsonArray.add(obj);

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	return jsonArray;
	}
	
	
	public static JSONArray attachmentToString(List<Attachment> attachments){
		JSONArray jsonArray = new JSONArray();
		for(Attachment attachment : attachments){
			JSONObject obj = new JSONObject();
		try {
			obj.put("attachmentid", attachment.getAttachmentid());
			obj.put("itemid",attachment.getAttachmentid());
			obj.put("postid", attachment.getPostid());
			obj.put("videoPath", attachment.getVideoPath());
			obj.put("imagePath",attachment.getImagePath());
			obj.put("audioPath",attachment.getAudioPath());
			obj.put("filePath",attachment.getFilePath());
			obj.put("type",attachment.getType());
			jsonArray.add(obj);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	return jsonArray;
	}
	
	
	public static JSONArray commentsInfoToString(List<Comment> comments){
		JSONArray jsonArray = new JSONArray();
		for(Comment commentInfo : comments){
			JSONObject obj = new JSONObject();
		try {
			obj.put("commentinfoid", commentInfo.getCommentinfoid());
			obj.put("itemId",commentInfo.getItemId());
			obj.put("postinfoid", commentInfo.getPostinfoid());
			obj.put("commentText", commentInfo.getCommentText());
			obj.put("userId", commentInfo.getUserId());
			obj.put("totalLiked", commentInfo.getTotalLiked());
			obj.put("totalUnLiked", commentInfo.getTotalUnLiked());
			obj.put("creationDate",commentInfo.getCreationDate());
			obj.put("modiifcationDate",commentInfo.getModificationDate());
			jsonArray.add(obj);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	return jsonArray;
	}


	public static JSONArray postClientToString(PostClient[] postClients){
		JSONArray jsonArray = new JSONArray();
		for(PostClient postClient : postClients){
			JSONObject obj = new JSONObject();
			Post post = postClient.getPost();
		try {
			obj.put("postinfoid", post.getId());
			obj.put("locale",post.getLocale());
			obj.put("accessType", post.getAccessType());
			obj.put("deleted", post.isDeleted());
			obj.put("deleteCode",post.getDeletedCode());
			
			obj.put("state",post.getState());
			if(post.getDescription() != null) {
				obj.put("description", URLDecoder.decode(post.getDescription(),  StandardCharsets.UTF_8));
			}
			
			obj.put("eventDate",post.getEventDate());
			obj.put("memoryDate",post.getMemoryDate());
			
			//set comments 
			obj.put("comments", commentsInfoToString(postClient.getComments()));

			//set attachments
			obj.put("attachments", attachmentToString(postClient.getAttachments()));
			obj.put("creationDate", post.getCreatedTime());
			jsonArray.add(obj);

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	return jsonArray;
	}
	
	
	public static JSONArray profileToString(Profile profileInfo){
		JSONArray jsonArray = new JSONArray();
		JSONObject obj = new JSONObject();
		try {
		obj.put("profileinfoid", profileInfo.getProfileinfoid());
		obj.put("userid",profileInfo.getUserid());
		obj.put("birthDate", profileInfo.getBirthDate());
		obj.put("hideinpublicsearch", profileInfo.isHideInPublicsearch());
		obj.put("city", profileInfo.getCity());
		obj.put("creationDate",profileInfo.getCreationDate());
		obj.put("modificationDate", profileInfo.getModificationDate());
		obj.put("country", profileInfo.getCountry());
		obj.put("fullname", profileInfo.getFullname());
		obj.put("photopath", profileInfo.getIconName());
		obj.put("title", profileInfo.getTitle());
		obj.put("iconName", profileInfo.getIconName());
		obj.put("school", profileInfo.getSchool());
		obj.put("workplace", profileInfo.getWorkplace());
		obj.put("education", profileInfo.getEducation());
		obj.put("freeTextProfile", profileInfo.getFreeTextProfile());
		obj.put("title", profileInfo.getTitle());
		obj.put("locale", profileInfo.getLocale());
		obj.put("phonenumber", profileInfo.getPhonenumber());
		obj.put("emailaddress", profileInfo.getEmailaddress());
		obj.put("searechKeys", profileInfo.getSearechKeys());
		obj.put("hideInPublicsearch", profileInfo.isHideInPublicsearch());
		obj.put("hashTags", profileInfo.getHashTags());
		obj.put("subscribedIds", profileInfo.getSubscribedIds());
		obj.put("tags", profileInfo.getTags());
		obj.put("userid", profileInfo.getUserid());
		obj.put("creationDate", profileInfo.getCreationDate());
		jsonArray.add(obj);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return jsonArray;
	}
}
