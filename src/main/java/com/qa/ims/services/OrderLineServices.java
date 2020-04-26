package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dao.LineDao;
import com.qa.ims.persistence.domain.OrderLine;

public class OrderLineServices implements LineServices<OrderLine> {

	private LineDao<OrderLine> orderLineDao;

	public OrderLineServices(LineDao<OrderLine> orderLineDao) {
		this.orderLineDao = orderLineDao;
	}

	@Override
	public List<OrderLine> readAll(Long id) {
		// TODO Auto-generated method stub
		return orderLineDao.readAll(id);
	}

	@Override
	public OrderLine create(OrderLine t) {
		// TODO Auto-generated method stub
		return orderLineDao.create(t);
	}

	@Override
	public OrderLine update(OrderLine t) {
		// TODO Auto-generated method stub
		return orderLineDao.update(t);
	}

	@Override
	public void delete(Long line_id) {
		// TODO Auto-generated method stub
		orderLineDao.delete(line_id);

	}

}
