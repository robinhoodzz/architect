package com.mashibing.arika.service;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mashibing.arika.entity.Item;
import com.mashibing.arika.mapper.ItemDAO;

@Service
public class ItemService  {

	@Autowired
	ItemDAO itemDao;
	
	public Item insert(Item item) {

		itemDao.insert(item);
		return item;
	}

	public Item findById(int id) {
		return itemDao.selectByPrimaryKey(id);		
	}

}
