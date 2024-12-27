package com.porasl.contentservices.service;

import java.util.List;

import com.porasl.contentservices.domain.ChannelInfo;

public interface ChannelService
{
   public ChannelInfo createOrUpdate(ChannelInfo channelInfo);
   public List<ChannelInfo> getChannelInfos();
   public ChannelInfo getChannelInfo(long channelInfoid); 
   public ChannelInfo getChannelInfoByUserId(long userid);
   public ChannelInfo getChannelInfoByUserName(String username);
   public void deleteChannelInfo(long channelInfoid);
   public boolean isChannelOwner(String loggedInUser, long channelId);
    
}
