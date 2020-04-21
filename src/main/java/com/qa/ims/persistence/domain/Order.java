package com.qa.ims.persistence.domain;

public class Order {

	private Long orderId;
	private Long customerId;
	private String date;
	private double total;

	public Order(Long customerId, String date, double total) {
		this.customerId = customerId;
		this.date = date;
		this.total = total;
	}

	public Order(Long orderId, Long customerId, String date, double total) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.date = date;
		this.total = total;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "order id:" + orderId + " customer id:" + customerId + " date:" + date + " total price:£" + total;
	}

}
