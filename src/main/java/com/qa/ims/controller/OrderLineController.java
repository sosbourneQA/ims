package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.Ims;
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
		LOGGER.info("what is the id of the order line you would like to read?");
		Long line_id = Long.valueOf(getInput());
		List<OrderLine> orderLine = orderLineService.readAll(line_id);
		for (OrderLine element : orderLine) {
			LOGGER.info(element.toString());
		}
		LOGGER.info("type 'RETURN' if you would like to go back to the options menu");
		String answer = getInput();
		if (answer.toLowerCase().equals("return")) {
			Ims newIms = new Ims();
			newIms.imsSystem();
		}
		return null;
	}

	@Override
	public OrderLine create() {
		LOGGER.info("what is the id of the order associated with this order line?");
		Long order_id = Long.valueOf(getInput());
		LOGGER.info("what is the id of the item that you would like in this order line?");
		Long item_id = Long.valueOf(getInput());
		LOGGER.info("how many would you like to purachse?");
		Long quantity = Long.valueOf(getInput());
		orderLineService.create(new OrderLine(order_id, item_id, quantity));
		LOGGER.info("order line created");
		LOGGER.info("type 'RETURN' if you would like to go back to the options menu");
		String answer = getInput();
		if (answer.toLowerCase().equals("return")) {
			Ims newIms = new Ims();
			newIms.imsSystem();
		}
		return null;
	}

	@Override
	public OrderLine update() {
		LOGGER.info("please enter the id of the order line you would like to update");
		Long order_line_id = Long.valueOf(getInput());
		LOGGER.info("what is the order id of the order line you would like to update?");
		Long order_id = Long.valueOf(getInput());
		LOGGER.info("what is the id of the item in the order line?");
		Long item_id = Long.valueOf(getInput());
		LOGGER.info("what is the updated quantity of the item that you would like to purachse?");
		Long quantity = Long.valueOf(getInput());
		orderLineService.update(new OrderLine(order_line_id, order_id, item_id, quantity));
		LOGGER.info("order line updated");
		LOGGER.info("type 'RETURN' if you would like to go back to the options menu");
		String answer = getInput();
		if (answer.toLowerCase().equals("return")) {
			Ims newIms = new Ims();
			newIms.imsSystem();
		}
		return null;
	}

	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the order line you would like to delete");
		Long line_id = Long.valueOf(getInput());
		orderLineService.delete(line_id);
		LOGGER.info("order line deleted");
		LOGGER.info("type 'RETURN' if you would like to go back to the options menu");
		String answer = getInput();
		if (answer.toLowerCase().equals("return")) {
			Ims newIms = new Ims();
			newIms.imsSystem();
		}

	}

}
