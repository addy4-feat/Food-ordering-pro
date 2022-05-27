package org.birlasoft.food.model;

public class Delivery {
	//\tDelivery_id\t\tdelivery_location\texcepted_arrival\tORDER_ID\t\tORDER_TIME"
	private int deliveryId;
	private String deliveryLoc;
	private String exArr;
	private int orderId;
	private String orderTime;
	public Delivery(int deliveryId, String deliveryLoc, String exArr, int orderId, String orderTime) {
		super();
		this.deliveryId = deliveryId;
		this.deliveryLoc = deliveryLoc;
		this.exArr = exArr;
		this.orderId = orderId;
		this.orderTime = orderTime;
	}
	public int getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}
	public String getDeliveryLoc() {
		return deliveryLoc;
	}
	public void setDeliveryLoc(String deliveryLoc) {
		this.deliveryLoc = deliveryLoc;
	}
	public String getExArr() {
		return exArr;
	}
	public void setExArr(String exArr) {
		this.exArr = exArr;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	@Override
	public String toString() {
		return "Delivery [deliveryId=" + deliveryId + ", deliveryLoc=" + deliveryLoc + ", exArr=" + exArr + ", orderId="
				+ orderId + ", orderTime=" + orderTime + "]";
	}
	

}
