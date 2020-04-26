package com.qa.ims.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.services.ItemServices;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {

	@Mock
	private ItemServices itemServices;

	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer
	 * controller
	 */
	@Spy
	@InjectMocks
	private ItemController itemController;

	@Test
	public void readAllTest() {
		ItemController itemController = new ItemController(itemServices);
		List<Item> items = new ArrayList<>();
		items.add(new Item("chess", 20.00));
		items.add(new Item("call_of_duty", 40.00));
		items.add(new Item("harry_potter", 10.00));
		Mockito.when(itemServices.readAll()).thenReturn(items);
		assertEquals(items, itemController.readAll());
	}

	@Test
	public void createTest() {
		String name = "football";
		Double price = 30.00;
		Mockito.doReturn(name, price.toString()).when(itemController).getInput();
//		double double_val = Double.valueOf(price);

		Item item = new Item(name, price);
		Item savedItem = new Item(1L, "football", 30.00);
		Mockito.when(itemServices.create(item)).thenReturn(savedItem);
		assertEquals(savedItem, itemController.create());
	}

	/**
	 * 
	 */
	@Test
	public void updateTest() {
		Long id = 1L;
		String name = "ipad";
		Double price = 800.00;

		Mockito.doReturn(id.toString(), name, price.toString()).when(itemController).getInput();
//		double double_val = Double.valueOf(price);

		Item item = new Item(1L, name, price);
		Mockito.when(itemServices.update(item)).thenReturn(item);
		assertEquals(item, itemController.update());
	}

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the
	 * delete method
	 */
	@Test
	public void deleteTest() {
		Long id = 1L;
		Mockito.doReturn(id.toString()).when(itemController).getInput();
		itemController.delete();
		Mockito.verify(itemServices, Mockito.times(1)).delete(1L);
	}

}
