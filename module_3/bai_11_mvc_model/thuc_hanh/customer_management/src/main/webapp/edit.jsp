<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 10/20/2021
  Time: 8:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<form action="?action=edit&id=${customer.id}" method="post">
    <label for="id">
        ID:
        <input type="text" id="id" name="id" value="${customer.id}" disabled>
    </label> <br/>
    <label for="name">
        Name:
        <input type="text" id="name" name="name" value="${customer.name}">
    </label> <br/>
    <label for="email">
        Email:
        <input type="text" id="email" name="email" value="${customer.email}">
    </label> <br/>
    <label for="address">
        Address:
        <input type="text" id="address" name="address" value="${customer.address}">
    </label> <br/>
    <button type="submit">Cập nhật</button>
</form>
</body>
</html>
