<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 10/21/2021
  Time: 10:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm mới sản phẩm</title>
</head>
<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }
    body {
        font-family: Tahoma;
        width: 500px;
        margin: 100px auto;
    }

    .auth-form {
        width: 500px;
    }

    h3 {
        font-size: 23px;
        text-align: center;
        color: #00e100;
    }

    form {
        margin-top: 20px;
        overflow: hidden;
        padding: 0 20px 0px;
        width: 100%;
        border: 1px solid #ccc;
    }
    form .label span {
        padding-bottom: 10px;
        font-size: 17px;
    }
    form .label {
        margin: 30px 0;
    }
    form input {
        width: 100%;
        height: 35px;
        outline: none;
        font-size: 16px;
        padding: 0 15px;
        margin-top: 10px;
        border: 1px solid #ccc;
    }

    button, a {
        text-decoration: none;
        display: flex;
        justify-content: center;
        align-items: center;
        background: #00e100;
        width: 100%;
        height: 40px;
        font-size: 17px;
        color: white;
        outline: none;
        border: none;
        margin: 10px 0;
    }
    button:hover,
    a:hover {
        background: #698000;
        cursor: pointer;
    }
</style>
<body>
<div class="auth-form">
    <h3>Thêm một sản phẩm mới</h3>
    <form action="product?action=create" method="post">
        <div class="label">
            <span>Nhập tên: </span>
            <input type="text" name="name" placeholder="Nhập tên sản phẩm">
        </div>
        <div class="label">
            <span>Nhập giá: </span>
            <input type="text" name="price" placeholder="Nhập giá sản phẩm">
        </div>
        <div class="label">
            <a href="/">Trở lại</a>
            <button type="submit">Thêm</button>
        </div>
    </form>
</div>
</body>
</html>
