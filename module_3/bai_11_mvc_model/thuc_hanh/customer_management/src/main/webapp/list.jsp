<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 10/17/2021
  Time: 12:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Management</title>
</head>
<style>
    body {
        width: 700px;
        height: 300px;
        margin: 0 auto;
    }

    table {
        width: 100%;
        height: 100%;
        text-align: center;
    }

    h2 {
        text-align: center;
        font-size: 40px;
    }

    a {
        display: block;
        padding: 12px -1px;
        font-size: 16px;
    }


    #btn-create {
        margin-top: 15px;
        display: block;
        width: 30px;
        padding: 12px 25px;
        background-color: green;
        text-decoration: none;
        color: white;
        font-size: 16px;
    }
</style>
<body>
<h2>Danh sách khách hàng</h2>
<table border="1" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Email</th>
        <th>Địa chỉ</th>
        <th>Chỉnh sửa</th>
        <th>Xóa khách hàng</th>
    </tr>
    <c:forEach var="customer" items="${customers}">
        <tr>
            <td>${customer.getId()}</td>
            <td>${customer.getName()}</td>
            <td>${customer.getEmail()}</td>
            <td>${customer.getAddress()}</td>
            <td><a href="?action=edit&id=${customer.getId()}">Chỉnh sửa</a></td>
            <td><a href="?action=delete&id=${customer.getId()}">Xóa</a></td>
        </tr>
    </c:forEach>
</table>
<a id="btn-create" href="?action=create">Add</a>
</body>
</html>
