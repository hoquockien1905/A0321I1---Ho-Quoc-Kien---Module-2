<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 10/18/2021
  Time: 9:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<form action="?action=create" method="post">
    <label for="name">
        Name:
        <input type="text" id="name" name="name">
    </label> <br/>
    <label for="email">
        Email:
        <input type="text" id="email" name="email">
    </label> <br/>
    <label for="address">
        Address:
        <input type="text" id="address" name="address">
    </label> <br/>
    <button type="submit">Create</button>
</form>
</body>
</html>
