package com.Tap.Model;

public class Restaurant {
	
	    private int restaurantId;
	    private String name;
	    private String address;
	    private String phoneNumber;
	    private String cuisineType;
	    private int deliveryTime;
	    private int adminUserId;
	    private double rating;
	    private boolean isActive;
	    private String imagePath;

	    public Restaurant() {}

		public Restaurant(int restaurantId, String name, String address, String phoneNumber, String cuisineType,
				int deliveryTime, int adminUserId, double rating, boolean isActive, String imagePath) {
			super();
			this.restaurantId = restaurantId;
			this.name = name;
			this.address = address;
			this.phoneNumber = phoneNumber;
			this.cuisineType = cuisineType;
			this.deliveryTime = deliveryTime;
			this.adminUserId = adminUserId;
			this.rating = rating;
			this.isActive = isActive;
			this.imagePath = imagePath;
		}

		public int getRestaurantId() {
			return restaurantId;
		}

		public void setRestaurantId(int restaurantId) {
			this.restaurantId = restaurantId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getCuisineType() {
			return cuisineType;
		}

		public void setCuisineType(String cuisineType) {
			this.cuisineType = cuisineType;
		}

		public int getDeliveryTime() {
			return deliveryTime;
		}

		public void setDeliveryTime(int deliveryTime) {
			this.deliveryTime = deliveryTime;
		}

		public int getAdminUserId() {
			return adminUserId;
		}

		public void setAdminUserId(int adminUserId) {
			this.adminUserId = adminUserId;
		}

		public double getRating() {
			return rating;
		}

		public void setRating(double rating) {
			this.rating = rating;
		}

		public boolean isActive() {
			return isActive;
		}

		public void setActive(boolean isActive) {
			this.isActive = isActive;
		}

		public String getImagePath() {
			return imagePath;
		}

		public void setImagePath(String imagePath) {
			this.imagePath = imagePath;
		}
		@Override
		public String toString() {
			return restaurantId+" "+ name+" "+address+" "+ phoneNumber+" "+
			cuisineType+" "+deliveryTime+" "+adminUserId+" "+rating+" "+
			 isActive+" "+imagePath;
		}
	    


}
