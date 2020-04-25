package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.OrderLine;
import com.qa.ims.services.LineServices;
import com.qa.ims.utils.Utils;

public class OrderLineController implements CrudController<OrderLine> {

	public static final Logger LOGGER = Logger.getLogger(OrderLineController.class);

	private LineServices<OrderLine> orderLineService;

	public OrderLineController(LineServices<OrderLine> orderLineService) {
		this.orderLineService = orderLineService;
	}

	String getInput() {
		return Utils.getInput();
	}

	@Override
	public List<OrderLine> readAll() {
		// TODO Auto-generated method stub
		LOGGER.info("what is the id of the order line you would like to read?");
		Long line_id = Long.valueOf(getInput());
		List<OrderLine> orderLine = orderLineService.readAll(line_id);
		for (OrderLine element : orderLine) {
			LOGGER.info(element.toString());
		}
		return orderLine;
	}

	@Override
	public OrderLine create() {
		// TODO Auto-generated method stub
		LOGGER.info("what is the id of the order associated with this order line?");
		Long order_id = Long.valueOf(getInput());
		LOGGER.info("what is the id of the item that you would like in this order line?");
		Long item_id = Long.valueOf(getInput());
		LOGGER.info("how many would you like to purachse?");
		Long quantity = Long.valueOf(getInput());
		OrderLine orderLine = orderLineService.create(new OrderLine(order_id, item_id, quantity));
		LOGGER.info("order line created");
		return orderLine;
	}

	@Override
	public OrderLine update() {
		// TODO Auto-generated method stub
		LOGGER.info("please enter the id of the order line you would like to update");
		Long order_line_id = Long.valueOf(getInput());
		LOGGER.info("what is the order id of the order line you would like to update?");
		Long order_id = Long.valueOf(getInput());
		LOGGER.info("what is the id of the item in the order line?");
		Long item_id = Long.valueOf(getInput());
		LOGGER.info("what is the new quantity of the item that you would like to purachse?");
		Long quantity = Long.valueOf(getInput());
		OrderLine orderLine = orderLineService.update(new OrderLine(order_line_id, order_id, item_id, quantity));
		LOGGER.info("order line updated");
		return orderLine;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		LOGGER.info("Please enter the order id of the order line you would like to delete");
		Long order_id = Long.valueOf(getInput());
		LOGGER.info("Please enter the item id of the order line you would like to delete");
		Long item_id = Long.valueOf(getInput());
		orderLineService.delete(order_id, item_id);
		LOGGER.info("order line deleted");

	}

}
