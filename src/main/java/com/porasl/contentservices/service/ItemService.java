package com.porasl.contentservices.service;


import java.util.List;

import com.porasl.contentservices.domain.ItemInfo;

public interface ItemService
{
   public ItemInfo createOrUpdate(ItemInfo itemInfo);
   public List<ItemInfo> getItems(String userId);
   public List<ItemInfo> getInCompletedItems();
   public ItemInfo getItem(long string, long itemId);
   public List<ItemInfo> getItemFeatureds(String locale);
   public void deleteItem(long itemId);
}

