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
		return customerDao.readAll();
	}

	@Override
	public Item create(Item item) {
		// TODO Auto-generated method stub
		return customerDao.create(customer);
	}

	@Override
	public Item update(Item item) {
		// TODO Auto-generated method stub
		return customerDao.update(customer);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		return customerDao.delete(customer);

	}

}
