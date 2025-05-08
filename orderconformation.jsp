<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>🎉 Order Confirmation 🎉</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: url('<%= request.getContextPath() %>/images/orderconfrmation.jpg') no-repeat center center/cover;      
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-size: cover;
        }
      .container {
   		 background: rgba(255, 255, 255, 0.9);
    	padding: 40px;
    	border-radius: 15px;
    	box-shadow: 0 8px 25px rgba(0, 0, 0, 0.3);
    	width: 95%;
    	max-width: 700px; /* Increased for better layout */
		text-align: center;
        h2 {
            color: #28a745;
            margin-bottom: 20px;
            font-size: 28px;
        }
        p {
            color: #444;
            font-size: 20px;
            margin: 15px 0;
        }
        .btn {
            display: inline-block;
            background-color: #007bff;
            color: white;
            padding: 14px 24px;
            text-decoration: none;
            border-radius: 10px;
            margin-top: 30px;
            font-size: 18px;
            transition: background 0.3s, transform 0.2s;
        }
        .btn:hover {
            background-color: #0056b3;
            transform: scale(1.05);
        }
        .order-image {
            width: 80px;
            height: auto;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
    	<h1>✅ Order Confirmed 🚴‍♂️📦</h1>
    	
        <h2>🎉 Thank You for Your Order! 🎉</h2>
        <p>✅ Your order has been placed successfully.</p>
        <a href="cart.jsp" class="btn">🛍️ Continue Shopping</a>
    </div>
</body>
</html>


