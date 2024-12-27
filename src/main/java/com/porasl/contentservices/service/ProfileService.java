package com.porasl.contentservices.service;

import java.util.List;

import com.porasl.contentservices.domain.ProfileInfo;

public interface ProfileService
{
   public ProfileInfo createOrUpdate(ProfileInfo profileInfo);
   public List<ProfileInfo> getProfileInfos();
   public ProfileInfo getProfileInfoWithUserId(long userid);
   public ProfileInfo getProfileInfo(long profileInfoid); 
   public void deleteProfileInfo(long ProfileInfoid);
}
