package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = Logger.getLogger(OrderController.class);

	private CrudServices<Order> orderService;

	public OrderController(CrudServices<Order> OrderService) {
		this.orderService = orderService;
	}

	String getInput() {
		return Utils.getInput();
	}

	// lists all orders

	@Override
	public List<Order> readAll() {
		// TODO Auto-generated method stub
		List<Order> orders = orderService.readAll();
		for (Order order : orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}

	// user creates a new order

	@Override
	public Order create() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order update() {
		// TODO Auto-generated method stub
		return null;
	}

	//

	@Override
	public void delete() {
		// TODO Auto-generated method stub

		LOGGER.info("PLease enter the id of the order you would like to delete?");
		orderService.delete(Long.valueOf(getInput()));
		LOGGER.info("order deleted");

	}

}
