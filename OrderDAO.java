package com.Tap.DAO;

import com.Tap.Model.Order;
import java.util.List;

	public interface OrderDAO {
	    void placeOrder(Order order);
	    Order getOrder(int orderId);
	    void updateOrderStatus(int orderId, String status);
	    void deleteOrder(int orderId);
	    List<Order> getAllOrdersByUser(int userId);
	


}
