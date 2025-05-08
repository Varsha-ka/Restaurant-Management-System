<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.Tap.Model.Cart" %>
<%@ page import="com.Tap.Model.CartItem" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Cart</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap">
    <style>
        /* Base styles */
        body {
            font-family: 'Poppins', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f7f7f7;
        }
        
        /* Base styles */
body {
    font-family: 'Poppins', sans-serif;
    margin: 0;
    padding: 0;
    background: linear-gradient(135deg, #f7f7f7, #e0e0e0); /* Gradient background */
    min-height: 100vh;
}

h1 {
    font-size: 36px;
    text-align: center;
    color: #333;
    margin-top: 40px;
}

.cart-container {
    max-width: 1200px;
    margin: 40px auto;
    padding: 30px;
    background-color: #fff;
    border-radius: 10px;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
}
        

        h1 {
            font-size: 36px;
            text-align: center;
            color: #333;
            margin-top: 40px;
        }

        .cart-container {
            max-width: 1200px;
            margin: 40px auto;
            padding: 30px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        }

        .cart-items {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            gap: 20px;
        }

        .cart-item {
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.05);
        }

        .cart-item img {
            max-width: 100%;
            height: auto;
            border-radius: 8px;
        }

        .cart-item-details {
            margin-top: 15px;
        }

        .cart-item-details h3 {
            font-size: 18px;
            color: #333;
        }

        .cart-item-details p {
            color: #777;
            font-size: 14px;
        }

        .quantity-controls {
            display: flex;
            align-items: center;
            gap: 10px;
            margin-top: 10px;
        }

        .quantity-controls button {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 8px 12px;
            font-size: 16px;
            cursor: pointer;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        .quantity-controls button:hover {
            background-color: #45a049;
        }

        .remove-btn {
            background-color: #f44336;
            color: white;
            border: none;
            padding: 8px 15px;
            font-size: 16px;
            cursor: pointer;
            border-radius: 5px;
            margin-top: 10px;
            transition: background-color 0.3s;
        }

        .remove-btn:hover {
            background-color: #d32f2f;
        }

        .total {
            text-align: right;
            font-size: 22px;
            font-weight: 600;
            margin-top: 20px;
        }

        .add-more-items {
            text-align: center;
            margin-top: 30px;
        }

        .add-more-items a {
            text-decoration: none;
            color: #4CAF50;
            font-size: 18px;
            border: 2px solid #4CAF50;
            padding: 10px 20px;
            border-radius: 30px;
            transition: background-color 0.3s, color 0.3s;
        }

        .add-more-items a:hover {
            background-color: #4CAF50;
            color: white;
        }

        .empty-cart {
            text-align: center;
            color: #757575;
            font-size: 18px;
            margin-top: 20px;
        }

        .proceed-btn {
            background-color: #4CAF50;
            color: white;
            padding: 15px 25px;
            font-size: 18px;
            border: none;
            border-radius: 30px;
            cursor: pointer;
            width: 100%;
            transition: background-color 0.3s;
        }

        .proceed-btn:hover {
            background-color: #45a049;
        }

        /* Mobile responsiveness */
        @media screen and (max-width: 768px) {
            .cart-items {
                grid-template-columns: 1fr;
            }
        }
    </style>
</head>
<body>
<h1>Your Cart</h1>

<div class="cart-container">
<%
Cart cart = (Cart) session.getAttribute("cart");
Integer restaurantId = (Integer) session.getAttribute("restaurantId");

if (cart != null && !cart.getItems().isEmpty()) {
%>

    <div class="cart-items">
        <% for (CartItem item : cart.getItems().values()) { %>
        <div class="cart-item">
            <div class="cart-item-details">
                <h3><%= item.getName() %></h3>
                <p>Price: <%= item.getPrice() %></p>
                <p>Total: <%= item.getTotalPrice() %></p>

                <div class="quantity-controls">
                    <form action="cart" method="post">
                        <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                        <input type="hidden" name="action" value="addItem">
                        <input type="hidden" name="restaurantId" value="<%= session.getAttribute("restaurantId") %>">
                        <input type="hidden" name="quantity" value="1">
                        <button class="quantity-btn">+</button>
                    </form>

                    <p><%= item.getQuantity() %></p>

                    <form action="cart" method="post" style="display:inline">
    				<input type="hidden" name="itemId" value="<%= item.getItemId() %>">
    				<input type="hidden" name="restaurantId" value="1">
    
    				<% if (item.getQuantity() > 1) { %>
       			   <input type="hidden" name="action" value="updateItem">
       			   <input type="hidden" name="quantity" value="<%= item.getQuantity() - 1 %>">
    			   <% } else { %>
       			   <input type="hidden" name="action" value="removeItem">
   				   <% } %>

   				 <button class="quantity-btn" <%= item.getQuantity() == 1 ? "" : "" %>>-</button>
				</form>

                </div>
            </div>

            <form action="cart" method="post">
                <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                <input type="hidden" name="action" value="removeItem">
                <input type="hidden" name="restaurantId" value="<%= session.getAttribute("restaurantId") %>">
                <input type="hidden" name="quantity" value="0">
                <button class="remove-btn">Remove</button>
            </form>
        </div>
        <% } %>
    </div>

    <div class="total">Grand Total: <%= cart.getTotalPrice() %></div>

    <div class="add-more-items">
        <a href="menu?restaurantId=<%= session.getAttribute("restaurantId") %>">Add More Items</a>
    </div>

<% } else { %>
    <p class="empty-cart">Your cart is empty</p>
    <div class="add-more-items">
        <a href="menu?restaurantId=<%= session.getAttribute("restaurantId") %>">Browse Menu</a>
    </div>
<% } %>

<% if(session.getAttribute("cart") != null) { %>
    <form action="checkout.jsp" method="post">
        <input type="submit" value="Proceed to Checkout" class="proceed-btn">
    </form>
<% } %>

</div>
</body>
</html>
