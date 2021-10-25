<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 10/20/2021
  Time: 4:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
</head>
<body>
<h1>Delete customer</h1>
<p><a href="customer-management">Back to customer list</a></p>
<form action="?action=delete&id=${customer.id}" method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>
            Customer information
        </legend>
        <table>
            <tr>
                <td>ID:</td>
                <td>${customer.id}</td>
            </tr>
            <tr>
                <td>ID:</td>
                <td>${customer.name}</td>
            </tr>
            <tr>
                <td>ID:</td>
                <td>${customer.email}</td>
            </tr>
            <tr>
                <td>ID:</td>
                <td>${customer.address}</td>
            </tr>
            <tr>
                <td><button type="submit">Xóa</button></td>
                <td><a href="customer-management">Back to customer list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
