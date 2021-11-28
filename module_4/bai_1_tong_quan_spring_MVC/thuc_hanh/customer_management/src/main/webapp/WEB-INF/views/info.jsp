<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
    <fieldset>
        <legend>
            Customer Information
        </legend>
        <form action="/" method="post">
            <div>
                <span>ID</span>
                <input type="text" readonly name="id" value="${customer.id}">
            </div>
            <div>
                <span>Name</span>
                <input type="text" name="name" value="${customer.name}">
            </div>
            <div>
                <span>Email</span>
                <input type="text" name="email" value="${customer.email}">
            </div>
            <div>
                <span>Address</span>
                <input type="text" name="address" value="${customer.address}">
            </div>
            <button type="submit">Update</button>
        </form>
    </fieldset>
</body>
</html>
