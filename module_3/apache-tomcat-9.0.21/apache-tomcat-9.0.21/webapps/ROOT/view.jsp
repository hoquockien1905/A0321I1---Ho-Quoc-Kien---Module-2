<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 10/22/2021
  Time: 12:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thông tin chi tiết</title>
</head>
<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: Tahoma;
    }

    body {
        width: 500px;
        margin: 100px auto;
    }

    form {
        width: 100%;
    }
    fieldset {
        margin: 20px 0;
    }
    h3 {
        color: #00e100;
        font-size: 23px;
        text-align: center;
    }
    h5 {
        color: #00e100;
        text-align: right;
    }
    .info-product {
        padding: 20px;
    }
    .info-product p {
        padding: 10px 0;
    }
    .btn {
        display: flex;
        justify-content: space-between;
    }
    .btn a {
        text-decoration: none;
        display: flex;
        justify-content: center;
        align-items: center;
        width: 100%;
        height: 35px;
        padding: 10px 0;
        margin: 10px;
        background: #00e100;
        color: white;
        border: none;
        font-size: 16px;
    }
     a:hover{
        cursor: pointer;
        background: #698000;
    }
    a {
        flex: 1;
    }
</style>
<body>
<h3>Thông tin chi tiết của sản phẩm</h3>
<fieldset>
    <legend>
        Thông tin chi tiết:
    </legend>
    <div class="info-product">
        <p>ID sản phẩm: ${product.id}</p>
        <p>Tên sản phẩm: ${product.name}</p>
        <p>Giá sản phẩm: ${product.price}</p>
    </div>
</fieldset>
<div class="btn">
    <a href="/">Trở lại</a>
</div>
</body>
</html>
