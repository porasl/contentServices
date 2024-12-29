package com.porasl.contentservices.service;


import java.util.List;

import com.porasl.contentservices.domain.Item;

public interface ItemService
{
   public Item createOrUpdate(Item itemInfo);
   public List<Item> getItems(String userId);
   public List<Item> getInCompletedItems();
   public Item getItem(long string, long itemId);
   public List<Item> getItemFeatureds(String locale);
   public void deleteItem(long itemId);
}

