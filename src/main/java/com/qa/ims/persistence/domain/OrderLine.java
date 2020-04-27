package com.qa.ims.persistence.domain;

public class OrderLine {

	private Long orderLineId;
	private Long orderId;
	private Long ItemId;
	private Long quantity;

	public OrderLine(Long orderId, Long itemId, Long quantity) {
		this.orderId = orderId;
		this.ItemId = itemId;
		this.quantity = quantity;
	}

	public OrderLine(Long orderLineId, Long orderId, Long itemId, Long quantity) {
		this.orderLineId = orderLineId;
		this.orderId = orderId;
		this.ItemId = itemId;
		this.quantity = quantity;
	}

	public Long getOrderLineId() {
		return orderLineId;
	}

	public void setOrderLineId(Long orderLineId) {
		this.orderLineId = orderLineId;
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
		return ItemId;
	}

	public void setItemId(Long itemId) {
		this.ItemId = itemId;
	}

	@Override
	public String toString() {
		return "order_line_id:" + orderLineId + " order_id:" + orderId + " item_id:" + ItemId + " quantity:" + quantity;
	}

}
