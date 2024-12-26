package com.porasl.contentservices.list;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.porasl.contentservices.content.Item;
import com.porasl.contentservices.list.ItemList;


@XmlRootElement(name="itemClients")
public class ItemList {
	private int count;
	private List<Item> items;

	public ItemList() {}
	
	public ItemList(List<Item> items) {
		this.items = items;
		this.count = items.size();
	}

	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	@XmlElement(name="itemClients")
	public List<Item> getItemClients() {
		return items;
	}
	
	public void setItemClients(List<Item> items) {
		this.items = items;
	}
}