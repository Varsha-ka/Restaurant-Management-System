package com.Tap.Servlet;

import java.io.IOException;

import com.Tap.DAOImp.MenuDAOImpl;
import com.Tap.Model.Cart;
import com.Tap.Model.CartItem;
import com.Tap.Model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")

public class CartServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		Cart cart=(Cart)session.getAttribute("cart");
		
		
		
		int newRestaurantId= Integer.parseInt(req.getParameter("restaurantId"));
		Integer currentRestaurantId =(Integer) session.getAttribute("restaurantId");
		
		
		if(cart==null||newRestaurantId!=currentRestaurantId) {
			cart=new Cart();
			session.setAttribute("cart", cart);
			session.setAttribute("restaurantId", newRestaurantId);
		}
		
		
		String action=req.getParameter("action");
		if(action.equals("addItem")) {
			addCartItems(req,cart);
			
		}
		else if(action.equals("updateItem")) {
			updateCartItems(req,cart);
			
		}
		else if(action.equals("removeItem")) {
			removeCartItems(req,cart);
		}
		
		session.setAttribute("cart", cart);
		resp.sendRedirect("cart.jsp");
		
	}


	

	private void addCartItems(HttpServletRequest req, Cart cart) {
		
		int itemId=Integer.parseInt(req.getParameter("itemId"));
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		
		MenuDAOImpl menuDAO= new MenuDAOImpl();
		Menu menuItem = menuDAO.getMenuItem(itemId);
		
		System.out.println("The menu in the cart Servlet"+menuItem);
		
		if(menuItem!=null) {
			CartItem item = new CartItem(menuItem.getMenuId(),menuItem.getRestaurantId(), menuItem.getItemName(),menuItem.getPrice(), quantity);
			cart.addItem(item);
		}
	}
	private void updateCartItems(HttpServletRequest req, Cart cart) {
		int itemId=Integer.parseInt(req.getParameter("itemId"));
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		cart.updateItem(itemId, quantity);
	}
	

	private void removeCartItems(HttpServletRequest req, Cart cart) {
		int itemId=Integer.parseInt(req.getParameter("itemId"));
		//int quantity=Integer.parseInt(req.getParameter("quantity"));
		cart.removeItem(itemId);
		
	}

}
