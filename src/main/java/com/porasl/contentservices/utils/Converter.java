package com.porasl.contentservices.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.porasl.contentservices.domain.Attachment;
import com.porasl.contentservices.domain.Comment;
import com.porasl.contentservices.domain.Item;
import com.porasl.contentservices.domain.Profile;
 

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
					obj.put("photo", profile.getIconname());
					obj.put("fullname", profile.getFullname());
					obj.put("userid", profile.getUserid());
					obj.put("birthDat", profile.getBirthdate());
					obj.put("city", profile.getCity());
					obj.put("country", profile.getCountry());
					obj.put("creationDate", profile.getCreationdate());
					obj.put("education", profile.getEducation());
					obj.put("emailAddress", profile.getEmailaddress());
					obj.put("freeTextProfile", profile.getFreetextprofile());
					obj.put("hashTags", profile.getHashtags());
					obj.put("modificationDate", profile.getModificationdate());
					obj.put("phonenumber", profile.getPhonenumber());
					obj.put("school", profile.getSchool());
					obj.put("searchKeys", profile.getSearechkeys());
					obj.put("locale", profile.getLocale());
					obj.put("tags", profile.getTags());
					obj.put("subscribeIds", profile.getSubscribedids());
					obj.put("hideinPublicSearch", profile.isHideinpublicsearch());
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
				if(item.getAudiopath() != null) {
					obj.put("audioPath",URLDecoder.decode(item.getAudiopath(), "UTF-8"));
				} else if(item.getImagepath() != null) {
					obj.put("imagePath",URLDecoder.decode(item.getImagepath(), "UTF-8"));
				}else if(item.getVideopath() != null) {
					obj.put("videoPath",URLDecoder.decode(item.getVideopath(), "UTF-8"));
				}else if(item.getFilepath() != null) {
					obj.put("filePath",URLDecoder.decode(item.getFilepath(), "UTF-8"));
				}
				obj.put("creationDate",item.getCreationdate());
				obj.put("modificationDate",item.getModificationdate());
				obj.put("expirationDate",item.getExpirationdate());
				obj.put("deletionDate",item.getDeletiondate());
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
	
	
	
	public static JSONArray attachmentToString(List<Attachment> attachments){
		JSONArray jsonArray = new JSONArray();
		for(Attachment attachment : attachments){
			JSONObject obj = new JSONObject();
		try {
			obj.put("id", attachment.getId());
			obj.put("itemid",attachment.getId());
			obj.put("postid", attachment.getPostid());
			obj.put("videoPath", attachment.getVideopath());
			obj.put("imagePath",attachment.getImagepath());
			obj.put("audioPath",attachment.getAudiopath());
			obj.put("filePath",attachment.getFilepath());
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
			obj.put("itemId",commentInfo.getItemid());
			obj.put("postinfoid", commentInfo.getPostinfoid());
			obj.put("commentText", commentInfo.getCommenttext());
			obj.put("userId", commentInfo.getUserid());
			obj.put("totalLiked", commentInfo.getTotalliked());
			obj.put("totalUnLiked", commentInfo.getTotalunliked());
			obj.put("creationDate",commentInfo.getCreationdate());
			obj.put("modiifcationDate",commentInfo.getModificationdate());
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
		obj.put("birthDate", profileInfo.getBirthdate());
		obj.put("hideinpublicsearch", profileInfo.isHideinpublicsearch());
		obj.put("city", profileInfo.getCity());
		obj.put("creationDate",profileInfo.getCreationdate());
		obj.put("modificationDate", profileInfo.getModificationdate());
		obj.put("country", profileInfo.getCountry());
		obj.put("fullname", profileInfo.getFullname());
		obj.put("photopath", profileInfo.getIconname());
		obj.put("title", profileInfo.getTitle());
		obj.put("iconName", profileInfo.getIconname());
		obj.put("school", profileInfo.getSchool());
		obj.put("workplace", profileInfo.getWorkplace());
		obj.put("education", profileInfo.getEducation());
		obj.put("freeTextProfile", profileInfo.getFreetextprofile());
		obj.put("title", profileInfo.getTitle());
		obj.put("locale", profileInfo.getLocale());
		obj.put("phonenumber", profileInfo.getPhonenumber());
		obj.put("emailaddress", profileInfo.getEmailaddress());
		obj.put("searechKeys", profileInfo.getSearechkeys());
		obj.put("hideInPublicsearch", profileInfo.isHideinpublicsearch());
		obj.put("hashTags", profileInfo.getHashtags());
		obj.put("subscribedIds", profileInfo.getSubscribedids());
		obj.put("tags", profileInfo.getTags());
		obj.put("userid", profileInfo.getUserid());
		obj.put("creationDate", profileInfo.getCreationdate());
		jsonArray.add(obj);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return jsonArray;
	}
}
