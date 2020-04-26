package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class OrderTest {

	private Order order;
	private Order other;

	@Before
	public void setUp() {
		order = new Order(1L, 1L, 200.0);
		other = new Order(1L, 1L, 200.0);
	}

	@Test(expected = NullPointerException.class)
	public void settersTest() {
		assertNotNull(order.getOrderId());
		assertNotNull(order.getCustomerId());
		assertNotNull(order.getTotal());

		order.setOrderId(null);
		assertNull(order.getOrderId());
		order.setCustomerId(null);
		assertNull(order.getCustomerId());
		order.setTotal(null);
		assertNull(order.getTotal());

	}

	@Test
	public void equalsWithNull() {
		assertFalse(order.equals(null));
	}

	@Test
	public void equalsWithDifferentObject() {
		assertFalse(order.equals(new Object()));
	}

	@Test
	public void createOrderWithId() {
		assertEquals(1L, order.getOrderId(), 0);
		assertEquals(1L, order.getCustomerId(), 0);
		assertEquals(200.0, order.getTotal(), 0);
	}

	@Test
	public void checkEquality() {
		assertTrue(order.equals(order));
	}

	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(order.equals(other));
	}

	@Test
	public void orderNameNullButOtherNameNotNull() {
		order.setCustomerId(null);
		assertFalse(order.equals(other));
	}

	@Test
	public void orderNamesNotEqual() {
		other.setCustomerId(2L);
		assertFalse(order.equals(other));
	}

	@Test
	public void checkEqualityBetweenDifferentObjectsNullCustomerId() {
		order.setCustomerId(null);
		other.setCustomerId(null);
		assertTrue(order.equals(other));
	}

	@Test
	public void nullId() {
		order.setOrderId(null);
		assertFalse(order.equals(other));
	}

	@Test
	public void nullIdOnBoth() {
		order.setOrderId(null);
		other.setOrderId(null);
		assertTrue(order.equals(other));
	}

	@Test
	public void otherIdDifferent() {
		other.setOrderId(2L);
		assertFalse(order.equals(other));
	}

	@Test
	public void nullTotal() {
		order.setTotal(null);
		assertFalse(order.equals(other));
	}

	@Test
	public void nullTotalOnBoth() {
		order.setTotal(null);
		other.setTotal(null);
		assertTrue(order.equals(other));
	}

	@Test
	public void otherTotalDifferent() {
		other.setTotal(300.0);
		assertFalse(order.equals(other));
	}

	@Test
	public void constructorWithoutId() {
		Order order = new Order(1L, 100.0);
		assertNull(order.getOrderId());
		assertNotNull(order.getCustomerId());
		assertNotNull(order.getTotal());
	}

	@Test
	public void hashCodeTest() {
		assertEquals(order.hashCode(), other.hashCode());
	}

	@Test
	public void hashCodeTestWithNull() {
		Order order = new Order(null, null);
		Order other = new Order(null, null);
		assertEquals(order.hashCode(), other.hashCode());
	}

	@Test
	public void toStringTest() {
		String toString = "order_id:1 customer_id:1 total:£200.0";
		assertEquals(toString, order.toString());
	}
}