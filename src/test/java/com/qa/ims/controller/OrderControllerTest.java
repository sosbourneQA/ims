package com.qa.ims.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.services.OrderServices;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	/**
	 * The thing I want to fake functionlity for
	 */
	@Mock
	private OrderServices orderServices;

	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer
	 * controller
	 */
	@Spy
	@InjectMocks
	private OrderController orderController;

//	@Test
//	public void readAllTest() {
//		OrderController orderController = new OrderController(orderServices);
//		List<Order> order = new ArrayList<>();
//		order.add(new Order(1L, 1L, 200.00));
//		order.add(new Order(2L, 2L, 250.00));
//		order.add(new Order(3L, 3L, 300.00));
//		Mockito.when(orderServices.readAll()).thenReturn(order);
//		assertEquals(order, orderController.readAll());
//	}

	@Test
	public void createTest() {
		Long customerId = 1L;
		Double total = 100.00;
		Mockito.doReturn(customerId.toString(), total.toString()).when(orderController).getInput();
		Order order = new Order(customerId, total);
		Order savedOrder = new Order(1L, 1L, 100.00);
		Mockito.when(orderServices.create(order)).thenReturn(savedOrder);
		assertEquals(savedOrder, orderController.create());
	}

	/**
	 * 
	 */
//	@Test
//	public void updateTest() {
//		Long id = 1L;
//		Long custId = 2L;
//		Double total = 50.00;
//		Mockito.doReturn(id.toString(), custId.toString(), total.toString()).when(orderController).getInput();
//		Order order = new Order(id, custId, total);
//		Mockito.when(orderServices.update(order)).thenReturn(order);
//		assertEquals(order, orderController.update());
//	}

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the
	 * delete method
	 */
	@Test
	public void deleteTest() {
		Long id = 1L;
		Mockito.doReturn(id.toString()).when(orderController).getInput();
		orderController.delete();
		Mockito.verify(orderServices, Mockito.times(1)).delete(1L);
	}

}
