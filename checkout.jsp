<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Checkout</title>
    <style>
        body {
            font-family: Arial, sans-serif;
			background: url('<%= request.getContextPath() %>/images/checkout.jpg') no-repeat center center/cover;      
     	    display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background: rgba(255, 255, 255, 0.95);
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
            width: 100%;
            max-width: 400px;
        }
        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }
        label {
            font-weight: bold;
            display: block;
            margin: 10px 0 5px;
            color: #555;
        }
        textarea, select, input {
            width: 100%;
            padding: 12px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 14px;
        }
        select {
            cursor: pointer;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
            margin-top: 20px;
            padding: 12px;
            font-size: 16px;
            border-radius: 6px;
            transition: background 0.3s ease-in-out;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        @media (max-width: 480px) {
            .container {
                width: 90%;
                padding: 20px;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Checkout</h2>
        <form action="checkout" method="post">
            <label for="address">Delivery Address:</label>
            <textarea id="address" name="address" required></textarea>

            <label for="payment">Payment Method:</label>
            <select id="payment" name="paymentMethod">
                <option value="Credit Card">Credit Card</option>
                <option value="Debit Card">Debit Card</option>
                <option value="Cash">Cash on Delivery</option>
            </select>

            <input type="submit" value="Place Order">
        </form>
    </div>
</body>
</html>
    
