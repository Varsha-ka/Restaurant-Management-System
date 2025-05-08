package com.Tap.Model;

import java.sql.Date;
import java.sql.Timestamp;

public class Order {
	
	    private int orderId;
	    private int restaurantId;
	    private int userId;
	    private Timestamp orderDate;
	    private double totalAmount;
	    private String status;
	    private String paymentMode;

	    public Order() {}

		public Order(int orderId, int restaurantId, int userId, Timestamp date, double totalAmount, String status,
				String paymentMode) {
			super();
			this.orderId = orderId;
			this.restaurantId = restaurantId;
			this.userId = userId;
			this.orderDate = date;
			this.totalAmount = totalAmount;
			this.status = status;
			this.paymentMode = paymentMode;
		}

		public int getOrderId() {
			return orderId;
		}

		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}

		public int getRestaurantId() {
			return restaurantId;
		}

		public void setRestaurantId(int restaurantId) {
			this.restaurantId = restaurantId;
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public Timestamp getOrderDate() {
			return orderDate;
		}

		public void setOrderDate(Timestamp orderDate) {
			this.orderDate = orderDate;
		}

		public double getTotalAmount() {
			return totalAmount;
		}

		public void setTotalAmount(double totalAmount) {
			this.totalAmount = totalAmount;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getPaymentMode() {
			return paymentMode;
		}

		public void setPaymentMode(String paymentMode) {
			this.paymentMode = paymentMode;
		}
		
		@Override
		public String toString() {
		return orderId+" "+restaurantId+" "+userId+" "+orderDate+" "+totalAmount
				+" "+status+" "+paymentMode;
		}

	   


}
