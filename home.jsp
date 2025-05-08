<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   
    
<%@page import="java.util.List, com.Tap.Model.Restaurant" %> 





<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Restaurant Finder</title>
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            margin: 0;
            padding: 0;
            background:    linear-gradient(to right, #FF7F50, #FFDAB9);;
            color: #333;
        }
        
        .hero {
            background: url('<%= request.getContextPath() %>/images/food2.jpg') no-repeat center center/cover;
            height: 60vh;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            text-align: center;
            color: white;
            position: relative;
            
        }

        .hero::after {
            content: "";
            position: absolute;
            top: 0; left: 0;
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.5);
        }

        .hero h1 {
            font-size: 42px;
            font-weight: bold;
            z-index: 1;
            position: relative;
        }

        .search-bar {
            width: 50%;
            display: flex;
            background: white;
            padding: 12px;
            border-radius: 30px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);
            z-index: 1;
            position: relative;
        }

        .search-bar input {
            flex: 1;
            padding: 12px;
            font-size: 18px;
            border: none;
            outline: none;
            border-radius: 30px;
        }

        .search-bar button {
           background:  white;
   			 color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 30px;
            cursor: pointer;
            font-size: 16px;
        }

        .restaurants {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(320px, 1fr));
            gap: 20px;
            padding: 40px;
        }

        .restaurant-card {
            background: white;
            border-radius: 15px;
            overflow: hidden;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.3);
            text-align: center;
            transition: transform 0.3s ease-in-out;
            padding-bottom: 20px;
        }

        .restaurant-card:hover {
            transform: translateY(-10px);
        }

        .restaurant-card img {
            width: 100%;
            height: 220px;
            object-fit: cover;
        }

        .restaurant-card h3 {
            margin: 15px 0 5px;
            font-size: 22px;
            color: #333;
        }

        .restaurant-card p {
            font-size: 16px;
            color: #666;
        }

        .rating {
            color: gold;
            font-size: 18px;
            margin: 10px 0;
        }

        .btn-view {
            display: inline-block;
            background: #ff4b5c;
            color: white;
            padding: 10px 20px;
            margin-top: 10px;
            text-decoration: none;
            border-radius: 20px;
            font-size: 16px;
            transition: background 0.3s;
        }

        .btn-view:hover {
            background: #ff2d3f;
        }

    </style>
</head>
<body>
    <div class="hero">
        <h1>Find the Best Restaurants</h1>
        <div class="search-bar">
            <input type="text" placeholder="Search for restaurants, cuisines...">
            <button>🔍</button>
        </div>
    </div>

    <div class="restaurants">
    
    <% 
        List<Restaurant> allrestaurants = (List<Restaurant>) request.getAttribute("restaurants");
        for (Restaurant r : allrestaurants) { 
    %>
     <a href="menu?restaurantId=<%= r.getRestaurantId() %>" 
     
     style="display: block; text-decoration: none; color: inherit;">
	<div class="restaurant-card">
   
        <img src="<%= request.getContextPath() + r.getImagePath() %>" alt="Restaurant Image">
        <h3><%= r.getName() %></h3>
        <p><%= r.getCuisineType() %></p>
        <div class="rating">
            <% for (int i = 0; i < r.getRating(); i++) { %> ⭐ <% } %>
        </div>
        <p>📍 Location: <%= r.getAddress() %></p>
        <p>📞 Contact: <%= r.getPhoneNumber() %></p>
        <div class="btn-view">View Details</div>
  
</div>
  </a>

        

    <% } %>
    
    </div>
</body>
</html>
    