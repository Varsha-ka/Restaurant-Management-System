package com.Tap.DAOImp;



	import com.Tap.DAO.OrderDAO;
	import com.Tap.Model.Order;
	import com.Tap.Utility.DBConnection;

	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;
	import java.sql.Connection;

	public class OrderDAOImpl implements OrderDAO {

	    @Override
	    public void placeOrder(Order order) {
	        String insertQuery = "INSERT INTO orders(restaurantId, userId, orderDate, totalAmount, status, paymentMode) VALUES (?, ?, ?, ?, ?, ?)";

	        try (Connection connection = DBConnection.getConnection();
	            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
	            preparedStatement.setInt(1, order.getRestaurantId());
	            preparedStatement.setInt(2, order.getUserId());
	            preparedStatement.setTimestamp(3, order.getOrderDate());
	            preparedStatement.setDouble(4, order.getTotalAmount());
	            preparedStatement.setString(5, order.getStatus());
	            preparedStatement.setString(6, order.getPaymentMode());

	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public Order getOrder(int orderId) {
	        String selectQuery = "SELECT * FROM orders WHERE orderId=?";
	        Order order = null;

	        try (Connection connection = DBConnection.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
	            preparedStatement.setInt(1, orderId);
	            ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                order = new Order(
	                    resultSet.getInt("orderId"),
	                    resultSet.getInt("restaurantId"),
	                    resultSet.getInt("userId"),
	                    resultSet.getTimestamp("orderDate"),
	                    resultSet.getDouble("totalAmount"),
	                    resultSet.getString("status"),
	                    resultSet.getString("paymentMode")
	                );
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return order;
	    }

	    @Override
	    public void updateOrderStatus(int orderId, String status) {
	        String updateQuery = "UPDATE orders SET status=? WHERE orderId=?";

	        try (Connection connection = DBConnection.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
	            preparedStatement.setString(1, status);
	            preparedStatement.setInt(2, orderId);

	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void deleteOrder(int orderId) {
	        String deleteQuery = "DELETE FROM orders WHERE orderId=?";

	        try (Connection connection = DBConnection.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
	            preparedStatement.setInt(1, orderId);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public List<Order> getAllOrdersByUser(int userId) {
	        String selectQuery = "SELECT * FROM orders WHERE userId=?";
	        List<Order> orderList = new ArrayList<>();

	        try (Connection connection = DBConnection.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
	            preparedStatement.setInt(1, userId);
	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                Order order = new Order(
	                    resultSet.getInt("orderId"),
	                    resultSet.getInt("restaurantId"),
	                    resultSet.getInt("userId"),
	                    resultSet.getTimestamp("orderDate"),
	                    resultSet.getDouble("totalAmount"),
	                    resultSet.getString("status"),
	                    resultSet.getString("paymentMode")
	                );
	                orderList.add(order);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return orderList;
	    }
	}



