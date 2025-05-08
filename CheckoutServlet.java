package com.Tap.Model;

import java.io.IOException;
import java.sql.Timestamp;

import com.Tap.DAO.OrderDAO;
import com.Tap.DAOImp.OrderDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
	
	private OrderDAO orderDAO;
	
	@Override
	public void init() throws ServletException {
		try {
			orderDAO = new OrderDAOImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Cart cart = (Cart) session.getAttribute("cart");

		System.out.println("Cart: " + cart);
		System.out.println("Cart items count: " + (cart != null ? cart.getItems().size() : "Cart is null"));

		if (cart != null && !cart.getItems().isEmpty()) {
			User user = (User) session.getAttribute("loggedInUser");

			if (user == null) {
				user = new User();
				user.setUserId(1); 
				user.setName("Guest");
			}

			Order order = new Order();
			order.setUserId(user.getUserId());

			Integer restaurantId = (Integer) session.getAttribute("restaurantId");
			if (restaurantId == null) {
				restaurantId = 1; // Default restaurant ID
			}
			order.setRestaurantId(restaurantId);

			order.setOrderDate(new Timestamp(System.currentTimeMillis())); // Use current time
			order.setPaymentMode("Cash on Delivery");  // Default payment mode
			order.setStatus("Pending");

			double totalAmount = 0;
			for (CartItem item : cart.getItems().values()) {
				totalAmount += item.getPrice() * item.getQuantity();
			}
			order.setTotalAmount(totalAmount);

			orderDAO.placeOrder(order);

			session.removeAttribute("cart");
			session.setAttribute("order", order);

			resp.sendRedirect("orderconformation.jsp");
		} else {
			resp.sendRedirect("cart.jsp");
			

		}
	}
}
