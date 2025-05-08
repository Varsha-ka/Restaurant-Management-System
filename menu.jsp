<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.List, com.Tap.Model.Menu" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delicious Menu</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            margin: 0;
            padding: 0;
            background: linear-gradient(135deg, #4CAF50, #81C784);
            text-align: center;
            color: #fff;
            height: 100%;
            overflow-x: hidden;
        }

        .menu-container {
            margin: 50px auto;
            padding: 40px;
            background-color: rgba(255, 255, 255, 0.9);
            border-radius: 15px;
            width: 90%;
            box-shadow: 0px 15px 25px rgba(0, 0, 0, 0.1);
        }

        .menu-title {
            font-size: 42px;
            color: #2C6B2F;
            margin-bottom: 20px;
            text-transform: uppercase;
            font-weight: 700;
            letter-spacing: 3px;
        }

        .menu-grid {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 30px;
            margin-top: 20px;
        }

        .menu-card {
            width: 280px;
            background-color: #fff;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0 8px 15px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            position: relative;
            padding-bottom: 20px;
        }

        .menu-card:hover {
            transform: translateY(-10px);
            box-shadow: 0 15px 25px rgba(0, 0, 0, 0.2);
        }

        .menu-card img {
            width: 100%;
            height: 150px;
            object-fit: cover;
            border-bottom: 5px solid #4CAF50;
        }

        .menu-card h3 {
            margin: 15px 0;
            font-size: 24px;
            color: #2C6B2F;
        }

        .menu-card p {
            font-size: 14px;
            color: #666;
            padding: 0 10px;
            margin: 10px 0;
            height: 60px; /* Ensures consistent layout */
            overflow: hidden;
        }

        .menu-card .price {
            font-size: 18px;
            color: #4CAF50;
            font-weight: bold;
        }

        .add-to-cart {
            display: inline-block;
            background-color: #4CAF50;
            color: #fff;
            border: none;
            padding: 10px 15px;
            font-size: 16px;
            cursor: pointer;
            border-radius: 5px;
            margin-top: 10px;
            transition: background-color 0.3s ease;
        }

        .add-to-cart:hover {
            background-color: #388E3C;
        }

        @media (max-width: 1024px) {
            .menu-card {
                width: 45%;
            }
        }

        @media (max-width: 768px) {
            .menu-card {
                width: 90%;
            }

            .menu-title {
                font-size: 32px;
            }
        }
    </style>
</head>
<body>
    <div class="menu-container">
        <h1 class="menu-title">🥗🍲 Our Special Menu 🍛🍚</h1> 
        <div class="menu-grid">
            <% 
                List<Menu> allmenu = (List<Menu>) request.getAttribute("menus");
                for (Menu r : allmenu) { 
            %>
            <div class="menu-card">
                <img src="<%= request.getContextPath() + r.getImagePath() %>" alt="<%= r.getItemName() %>">
                <h3><%= r.getItemName() %></h3>
                <p><%= r.getDescription() %></p> <!-- Added description -->
                <div class="price">₹<%= r.getPrice() %></div>
                
               <form action="cart" method="post">
                
                <input type="hidden" name="restaurantId" value="<%= request.getParameter("restaurantId")  %>">
                <input type="hidden" name="itemId" value="<%= r.getMenuId() %>">
                <input type="hidden" name="quantity" value="1" min="1">
                <input type="hidden" name="action" value="addItem" >
                
                <button class="add-to-cart" >🛒 Add to Cart</button>
                
                
                
                </form>
                
                
          <!-- -      <a href="order.jsp?name=<%= r.getItemName() %>&price=<%= r.getPrice() %>&desc=<%= r.getDescription() %>&image=<%= request.getContextPath() + r.getImagePath() %>" class="add-to-cart">🛒 Order Now</a> -->
                
            </div>
            <% } %>
        </div>
    </div>

    <!-- About Section -->
    <div class="about-section">
        <h2>About Our Cuisine <span>🍽️</span></h2>
        <p>We serve freshly prepared, flavorful dishes inspired by traditional and contemporary recipes from around the world. Our chefs use only the finest ingredients, ensuring every meal is delicious and memorable.</p>
        <p>Our mission is to deliver exceptional food that leaves you wanting more. Whether you're enjoying street food or fine dining, each bite promises satisfaction.</p>
    </div>

    <!-- Footer Section -->
    <div class="footer">
        <p>Follow Us:</p>
        <a href="#">Instagram 📸</a> | <a href="#">Facebook 👍</a> | <a href="#">Twitter 🐦</a>
        <p>&copy; 2025 Delicious Menu. All Rights Reserved.</p>
    </div>
    
    
    

    
   
</body>
</html>
