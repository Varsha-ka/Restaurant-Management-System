<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            text-align: center;
        }
        .container {
            width: 300px;
            margin: auto;
            padding: 20px;
            background: white;
            box-shadow: 0px 0px 10px 0px gray;
            border-radius: 8px;
            margin-top: 100px;
        }
        input {
            width: 90%;
            padding: 8px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button {
            width: 100%;
            padding: 8px;
            background-color: green;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: darkgreen;
        }
    </style>
</head>
<body>

    <div class="container">
        <h2>Login</h2>
        <form action="login" method="post">
            <input type="text" name="username" placeholder="Username" required>
            <input type="password" name="password" placeholder="Password" required>
            <button type="submit">Login</button>
        </form>

        <% if (request.getParameter("error") != null) { %>
            <p style="color: red;">Invalid username or password!</p>
        <% } %>

        <p>Don't have an account? <a href="signup.jsp">Sign Up</a></p>
    </div>

</body>
</html>
