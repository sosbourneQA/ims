package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class ItemController implements CrudController<Item> {

	public static final Logger LOGGER = Logger.getLogger(ItemController.class);

	private CrudServices<Item> itemService;

	public ItemController(CrudServices<Item> itemService) {
		this.itemService = itemService;
	}

	String getInput() {
		return Utils.getInput();
	}

	@Override
	public List<Item> readAll() {
//		 TODO Auto-generated method stub
		List<Item> customers = itemService.readAll();
		for (Item item : items) {
			LOGGER.info(item.toString());
		}
		return null;
	}

	@Override
	public Item create() {
		// TODO Auto-generated method stub
		LOGGER.info("Please enter an item name");
		String name = getInput();
		LOGGER.info("Please enter price");
		String p = getInput();
		double price = Double.parseDouble(p);
		Item item = itemService.create(new Item(name, price));
		return null;
	}

	@Override
	public Item update() {
		// TODO Auto-generated method stub
		LOGGER.info("please enter the id of the item you would like to update");
		Long id = Long.valueOf(getInput());
		LOGGER.info("please enter a name");
		String name = getInput();
		LOGGER.info("please enter a price");
		double price = Double.valueOf(getInput());
		Item item = itemService.update(new Item(name, price));
		LOGGER.info("Item Updated");
		return item;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		LOGGER.info("please enter the id of the item you would like to delete");
		Long id = Long.valueOf(getInput());
		itemService.delete(id);

	}

}
