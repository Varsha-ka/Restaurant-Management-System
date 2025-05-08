package com.Tap.Servlet;

import java.io.IOException;
import java.sql.Date;

import com.Tap.DAOImp.UserDAOImpl;
import com.Tap.Model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        // Default role is 'user', and set creation date
        String role = "user";
        Date createDate = new Date(System.currentTimeMillis());

        User newUser = new User(0, name, username, password, email, phone, address, role, createDate, null);

        UserDAOImpl userDAO = new UserDAOImpl();
        boolean isRegistered = userDAO.addUser(newUser);

        if (isRegistered) {
            response.sendRedirect("login.jsp");
        } else {
            response.sendRedirect("signup.jsp?error=1");
        }
    }
}
