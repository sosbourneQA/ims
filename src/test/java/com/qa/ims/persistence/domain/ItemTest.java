package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ItemTest {

	private Item item;
	private Item other;

	@Before
	public void setUp() {
		item = new Item(1L, "darts", 50.00);
		other = new Item(1L, "darts", 50.00);
	}

	@Test(expected = NullPointerException.class)
	public void settersTest() {
		assertNotNull(item.getId());
		assertNotNull(item.getName());
		assertNotNull(item.getPrice());

		item.setId(null);
		assertNull(item.getId());
		item.setName(null);
		assertNull(item.getName());
		item.setPrice(null);
		assertNull(item.getPrice());

	}

	@Test
	public void equalsWithNull() {
		assertFalse(item.equals(null));
	}

	@Test
	public void equalsWithDifferentObject() {
		assertFalse(item.equals(new Object()));
	}

	@Test
	public void createItemWithId() {
		assertEquals(1L, item.getId(), 0);
		assertEquals("darts", item.getName());
		assertEquals(50.00, item.getPrice(), 0.01);
	}

	@Test
	public void checkEquality() {
		assertTrue(item.equals(item));
	}

	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(item.equals(other));
	}

	@Test
	public void customerNameNullButOtherNameNotNull() {
		item.setName(null);
		assertFalse(item.equals(other));
	}

	@Test
	public void customerNamesNotEqual() {
		other.setName("rhys");
		assertFalse(item.equals(other));
	}

	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		item.setName(null);
		other.setName(null);
		assertTrue(item.equals(other));
	}

	@Test
	public void nullId() {
		item.setId(null);
		assertFalse(item.equals(other));
	}

	@Test
	public void nullIdOnBoth() {
		item.setId(null);
		other.setId(null);
		assertTrue(item.equals(other));
	}

	@Test
	public void otherIdDifferent() {
		other.setId(2L);
		assertFalse(item.equals(other));
	}

	@Test
	public void nullSurname() {
		item.setPrice(null);
		assertFalse(item.equals(other));
	}

	@Test
	public void nullSurnameOnBoth() {
		item.setPrice(null);
		other.setPrice(null);
		assertTrue(item.equals(other));
	}

	@Test
	public void otherSurnameDifferent() {
		other.setPrice(90.00);
		assertFalse(item.equals(other));
	}

	@Test
	public void constructorWithoutId() {
		Item item = new Item("darts", 50.00);
		assertNull(item.getId());
		assertNotNull(item.getName());
		assertNotNull(item.getPrice());
	}

	@Test
	public void hashCodeTest() {
		assertEquals(item.hashCode(), other.hashCode());
	}

	@Test
	public void hashCodeTestWithNull() {
		Item item = new Item(null, null);
		Item other = new Item(null, null);
		assertEquals(item.hashCode(), other.hashCode());
	}

	@Test
	public void toStringTest() {
		String toString = "id:1 name:darts price:£50.0";
		assertEquals(toString, item.toString());
	}

}
