<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 10/21/2021
  Time: 11:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>[Bài tập] Tạo ứng dụng quản lý sản phẩm</title>
</head>
<style>
  body {
    font-family: Tahoma;
    width: 800px;
    margin: 100px auto;
  }

  a {
    text-decoration: none;
  }

  h3 {
    text-align: center;
    font-size: 30px;
    color: #00e100;
  }

  table {
    width: 100%;
    text-align: center;
  }

  table tr {
    height: 40px;
  }

  table tr:nth-child(even) {
    background: #00e100;
  }


  table tr:nth-child(old) {
    background: white;
  }

  .add {
    display: block;
    margin-top: 35px;
    width: 133px;
    padding: 15px 8px;
    text-decoration: none;
    background: #00e100;
    color: white;
    font-size: 18px;
  }

  .add:hover {
    background: #698000;
  }
</style>
<body>
<div class="list-product">
  <h3>Danh sách sản phẩm</h3>
  <table border="1" style="border: green" cellspacing="0">
    <tr>
      <th>ID</th>
      <th>Tên sản phẩm</th>
      <th>Giá sản phầm</th>
      <th colspan="2">Cập nhật</th>
      <th>Chi tiết sản phẩm</th>
    </tr>
    <c:forEach var="product" items="${products}">
      <tr>
        <td>${product.id}</td>
        <td>${product.name}</td>
        <td>${product.price}</td>
        <td><a href="product?action=edit&id=${product.id}">Chỉnh sửa</a></td>
        <td><a href="product?action=delete&id=${product.id}">Xóa</a></td>
        <td><a href="product?action=view&id=${product.id}">Xem</a></td>
      </tr>
    </c:forEach>
  </table>
  <a class="add" href="?action=create">Thêm sản phẩm</a>
</div>
</body>
</html>
