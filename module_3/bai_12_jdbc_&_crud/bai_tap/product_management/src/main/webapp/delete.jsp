<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 10/21/2021
  Time: 10:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Xóa sản phẩm</title>
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
    .btn button, .btn a {
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
    .btn button:hover,
    .btn a:hover{
        cursor: pointer;
        background: #698000;
    }
    .btn button,
    .btn a {
        flex: 1;
    }
</style>
<body>
<form action="product?action=delete&id=${product.id}" method="post">
    <h3>Xóa sản phẩm</h3>
    <fieldset>
        <legend>
            Thông tin sản phầm:
        </legend>
        <div class="info-product">
            <p>ID sản phẩm: ${product.id}</p>
            <p>Tên sản phẩm: ${product.name}</p>
            <p>Giá sản phẩm: ${product.price}</p>
        </div>
    </fieldset>
    <h5>Bạn có chắc muốn xóa không?</h5>
    <div class="btn">
        <a href="/">Trở lại</a>
        <button type="submit">Xóa</button>
    </div>
</form>
</body>
</html>
