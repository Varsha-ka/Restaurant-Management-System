package com.Tap.Servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.Tap.DAOImp.MenuDAOImpl;
import com.Tap.Model.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/menu")
public class MenuSevlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("restaurantId"));
		
		MenuDAOImpl menuImpl = new MenuDAOImpl();
		List<Menu> menus = menuImpl.getMenuByRestaurant(id);
		
		System.out.println("Restaurant ID: " + id);  // Check if ID is correct
        if (menus == null) {
            System.out.println("Menus list is null!"); // Check if List is null
        } else {
            System.out.println("Number of menu items: " + menus.size());
            for (Menu menu : menus) {
                System.out.println("Menu Item: " + menu.getItemName() + ", Image Path: " + menu.getImagePath()); // Check menu details
            }
        }
		
        for (Menu menu : menus) {
			System.out.println(menu);
		}
		
		req.setAttribute("menus", menus);
		
		RequestDispatcher rd = req.getRequestDispatcher("/menu.jsp");
		rd.forward(req, resp);
		
		
		       
		        
		       
		    
		

		
		
		
		 
	}
	
	
	

}
