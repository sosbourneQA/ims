package com.qa.ims.persistence.domain;

public class OrderLine {

	private Long orderId;
	private Long itemId;
	private Long quantity;

	public OrderLine(Long itemId, Long quantity) {
		this.itemId = itemId;
		this.quantity = quantity;
	}

	public OrderLine(Long orderId, Long itemId, Long quantity) {
		this.orderId = orderId;
		this.itemId = itemId;
		this.quantity = quantity;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	@Override
	public String toString() {
		return "order id:" + orderId + "item id:" + itemId + "quantity" + quantity;
	}

}
