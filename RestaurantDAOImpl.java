package com.Tap.DAOImp;

import com.Tap.DAO.RestaurantDAO;
import com.Tap.Model.Restaurant;
import com.Tap.Utility.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDAOImpl implements RestaurantDAO {
	
	@Override
	public void addRestaurant(Restaurant restaurant) {
		String insert = "INSERT INTO restaurant(name, address, phoneNumber, cuisineType, deliveryTime, adminUserId, rating, isActive, imagePath) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
			preparedStatement.setString(1, restaurant.getName());
			preparedStatement.setString(2, restaurant.getAddress());
			preparedStatement.setString(3, restaurant.getPhoneNumber());
			preparedStatement.setString(4, restaurant.getCuisineType());
			preparedStatement.setInt(5, restaurant.getDeliveryTime());
			preparedStatement.setInt(6, restaurant.getAdminUserId());
			preparedStatement.setDouble(7, restaurant.getRating());
			preparedStatement.setBoolean(8, restaurant.isActive());
			preparedStatement.setString(9, restaurant.getImagePath());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Restaurant getRestaurant(int restaurantId) {
		String selectQuery = "SELECT * FROM restaurant WHERE restaurantId=?";
		Restaurant restaurant = null;

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
			preparedStatement.setInt(1, restaurantId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				restaurant = new Restaurant(
						resultSet.getInt("restaurantId"),
						resultSet.getString("name"),
						resultSet.getString("address"),
						resultSet.getString("phoneNumber"),
						resultSet.getString("cuisineType"),
						resultSet.getInt("deliveryTime"),
						resultSet.getInt("adminUserId"),
						resultSet.getDouble("rating"),
						resultSet.getBoolean("isActive"),
						resultSet.getString("imagePath")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return restaurant;
	}

	@Override
	public void updateRestaurant(Restaurant restaurant) {
		String update = "UPDATE restaurant SET name=?, address=?, phoneNumber=?, cuisineType=?, deliveryTime=?, adminUserId=?, rating=?, isActive=?, imagePath=? WHERE restaurantId=?";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(update)) {
			preparedStatement.setString(1, restaurant.getName());
			preparedStatement.setString(2, restaurant.getAddress());
			preparedStatement.setString(3, restaurant.getPhoneNumber());
			preparedStatement.setString(4, restaurant.getCuisineType());
			preparedStatement.setInt(5, restaurant.getDeliveryTime());
			preparedStatement.setInt(6, restaurant.getAdminUserId());
			preparedStatement.setDouble(7, restaurant.getRating());
			preparedStatement.setBoolean(8, restaurant.isActive());
			preparedStatement.setString(9, restaurant.getImagePath());
			preparedStatement.setInt(10, restaurant.getRestaurantId());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteRestaurant(int restaurantId) {
		String deleteQuery = "DELETE FROM restaurant WHERE restaurantId=?";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
			preparedStatement.setInt(1, restaurantId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		String selectAllQuery = "SELECT * FROM restaurant";
		List<Restaurant> restaurants = new ArrayList<>();
		
		Connection connection = DBConnection.getConnection();
	    if (connection == null) {
	        System.err.println("Failed to establish database connection.");
	        return restaurants;
	    }

		try (
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(selectAllQuery)) {

			while (resultSet.next()) {
				Restaurant restaurant = new Restaurant(
						resultSet.getInt("restaurantId"),
						resultSet.getString("name"),
						resultSet.getString("address"),
						resultSet.getString("phoneNumber"),
						resultSet.getString("cuisineType"),
						resultSet.getInt("deliveryTime"),
						resultSet.getInt("adminUserId"),
						resultSet.getDouble("rating"),
						resultSet.getBoolean("isActive"),
						resultSet.getString("imagePath")
						);
				restaurants.add(restaurant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return restaurants;
	}



}
