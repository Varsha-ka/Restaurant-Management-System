package com.Tap.Servlet;

import java.io.IOException;
import java.util.List;

import com.Tap.DAOImp.RestaurantDAOImpl;
import com.Tap.Model.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RestaurantDAOImpl restimpl= new RestaurantDAOImpl();
		List<Restaurant> allrestaurants = restimpl.getAllRestaurants();
		
		/*for (Restaurant restaurant : allrestaurants) {
			System.out.println(restaurant);
			
		}*/
		req.setAttribute("restaurants", allrestaurants);
		
		RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
		rd.forward(req, resp);
	}

}
