package org.birlasoft.food.model;

public class Payment {
//payment_id\tpaid_amount\torder_id
	private int paymentId;
	private int paymentAmnt;
	private int orderId;
	public Payment(int paymentId, int paymentAmnt, int orderId) {
		super();
		this.paymentId = paymentId;
		this.paymentAmnt = paymentAmnt;
		this.orderId = orderId;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public int getPaymentAmnt() {
		return paymentAmnt;
	}
	public void setPaymentAmnt(int paymentAmnt) {
		this.paymentAmnt = paymentAmnt;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", paymentAmnt=" + paymentAmnt + ", orderId=" + orderId + "]";
	}
	
}
