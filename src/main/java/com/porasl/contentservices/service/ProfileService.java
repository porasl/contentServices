package com.porasl.contentservices.service;

import java.util.List;

import com.porasl.contentservices.domain.Profile;

public interface ProfileService
{
   public Profile createOrUpdate(Profile profileInfo);
   public List<Profile> getProfileInfos();
   public Profile getProfileInfoWithUserId(long userid);
   public Profile getProfileInfo(long profileInfoid); 
   public void deleteProfileInfo(long ProfileInfoid);
}
