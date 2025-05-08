package com.Tap.Model;

public class CartItem {
	
	private int itemId;
	private int restaurantId;
	private String name;
	private double price;
	private int quantity;
	
	public CartItem() {
		// TODO Auto-generated constructor stub
	}
	public CartItem(int itemId,int restaurantId, String name, double price, int quantity) {
		super();
		this.itemId = itemId;
		this.restaurantId = restaurantId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return itemId+" "+name+" "+price+" "+quantity;
		
	}
	public double getTotalPrice() {
        return price * quantity;  // Just an example calculation
    }
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		restaurantId = restaurantId;
	}
	
	
	

}
