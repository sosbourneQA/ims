package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Item;

public class ItemServices implements CrudServices<Item> {

	private Dao<Item> itemDao;

	public ItemServices(Dao<Item> itemDao) {
		this.itemDao = itemDao;
	}

	@Override
	public List<Item> readAll() {
		// TODO Auto-generated method stub
		return itemDao.readAll();
	}

	@Override
	public Item create(Item item) {
		// TODO Auto-generated method stub
		return itemDao.create(item);
	}

	@Override
	public Item update(Item item) {
		// TODO Auto-generated method stub
		return itemDao.update(item);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		itemDao.delete(id);

	}

}
