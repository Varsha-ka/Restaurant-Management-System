package com.Tap.DAO;

import com.Tap.Model.Restaurant;
import java.util.List;

	public interface RestaurantDAO {
	    void addRestaurant(Restaurant restaurant);
	    Restaurant getRestaurant(int restaurantId);
	    void updateRestaurant(Restaurant restaurant);
	    void deleteRestaurant(int restaurantId);
	    List<Restaurant> getAllRestaurants();
	


}
