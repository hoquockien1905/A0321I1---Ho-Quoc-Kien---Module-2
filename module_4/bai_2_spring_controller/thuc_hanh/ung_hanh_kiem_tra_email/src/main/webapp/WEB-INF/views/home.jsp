<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 11/26/2021
  Time: 9:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email validate</title>
</head>
<body>
<form action="" method="post">
    <h3>Enter your email</h3>
    <input type="text" name="email">
    <button type="submit">Validate</button>
</form>
<h3 style="color: ${email.equals("Email is invalid!") ? 'red' : 'green  '}">${email}</h3>
</body>
</html>
