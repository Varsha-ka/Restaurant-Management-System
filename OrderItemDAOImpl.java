package com.Tap.DAOImp;



	import com.Tap.DAO.OrderItemDAO;
	import com.Tap.Model.OrderItem;
	import com.Tap.Utility.DBConnection;

	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;
	import java.sql.Connection;

	public class OrderItemDAOImpl implements OrderItemDAO {

	    @Override
	    public void addOrderItem(OrderItem orderItem) {
	        String insertQuery = "INSERT INTO order_items (orderId, menuId, quantity, totalAmount) VALUES (?, ?, ?, ?)";

	        try (Connection connection = DBConnection.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
	            preparedStatement.setInt(1, orderItem.getOrderId());
	            preparedStatement.setInt(2, orderItem.getMenuId());
	            preparedStatement.setInt(3, orderItem.getQuantity());
	            preparedStatement.setDouble(4, orderItem.getTotalAmount());

	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public OrderItem getOrderItem(int orderItemId) {
	        String selectQuery = "SELECT * FROM order_items WHERE orderItemId=?";
	        OrderItem orderItem = null;

	        try (Connection connection = DBConnection.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
	            preparedStatement.setInt(1, orderItemId);
	            ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                orderItem = new OrderItem(
	                    resultSet.getInt("orderItemId"),
	                    resultSet.getInt("orderId"),
	                    resultSet.getInt("menuId"),
	                    resultSet.getInt("quantity"),
	                    resultSet.getDouble("totalAmount")
	                );
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return orderItem;
	    }

	    @Override
	    public void updateOrderItem(OrderItem orderItem) {
	        String updateQuery = "UPDATE order_items SET orderId=?, menuId=?, quantity=?, totalAmount=? WHERE orderItemId=?";

	        try (Connection connection = DBConnection.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
	            preparedStatement.setInt(1, orderItem.getOrderId());
	            preparedStatement.setInt(2, orderItem.getMenuId());
	            preparedStatement.setInt(3, orderItem.getQuantity());
	            preparedStatement.setDouble(4, orderItem.getTotalAmount());
	            preparedStatement.setInt(5, orderItem.getOrderItemId());

	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void deleteOrderItem(int orderItemId) {
	        String deleteQuery = "DELETE FROM order_items WHERE orderItemId=?";

	        try (Connection connection = DBConnection.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
	            preparedStatement.setInt(1, orderItemId);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public List<OrderItem> getOrderItemsByOrder(int orderId) {
	        String selectQuery = "SELECT * FROM order_items WHERE orderId=?";
	        List<OrderItem> orderItemList = new ArrayList<>();

	        try (Connection connection = DBConnection.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
	            preparedStatement.setInt(1, orderId);
	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                OrderItem orderItem = new OrderItem(
	                    resultSet.getInt("orderItemId"),
	                    resultSet.getInt("orderId"),
	                    resultSet.getInt("menuId"),
	                    resultSet.getInt("quantity"),
	                    resultSet.getDouble("totalAmount")
	                );
	                orderItemList.add(orderItem);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return orderItemList;
	    }
	}



