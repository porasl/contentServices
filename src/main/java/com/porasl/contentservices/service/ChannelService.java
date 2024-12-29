package com.porasl.contentservices.service;

import java.util.List;

import com.porasl.contentservices.domain.Channel;

public interface ChannelService
{
   public Channel createOrUpdate(Channel channelInfo);
   public List<Channel> getChannelInfos();
   public Channel getChannelInfo(long channelInfoid); 
   public Channel getChannelInfoByUserId(long userid);
   public Channel getChannelInfoByUserName(String username);
   public void deleteChannelInfo(long channelInfoid);
   public boolean isChannelOwner(String loggedInUser, long channelId);
    
}
