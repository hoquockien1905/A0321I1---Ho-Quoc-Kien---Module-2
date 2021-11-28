<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>List Product</title>
</head>
<body>
<h1 th:replace="~{header.html :: h1('home')}"></h1>
<p>
    <a th:href="@{/create}">Add new product</a>
</p>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name product</th>
        <th>Price</th>
        <th>Description</th>
        <th>View</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <tr th:each="item : ${productList}">
        <td th:text="${item.getId()}"></td>
        <td th:text="${item.getNameProduct()}"></td>
        <td th:text="${item.getPrice()}"></td>
        <td th:text="${item.getDesc()}"></td>
        <td><a th:href="@{/view/{id}(id=${item.getId()})}">View</a></td>
        <td><a th:href="@{/edit/{id}(id=${item.getId()})}">Edit</a></td>
        <td><a th:href="@{/delete/{id}(id=${item.getId()})}">Delete</a></td>
    </tr>
</table>
</body>
</html>