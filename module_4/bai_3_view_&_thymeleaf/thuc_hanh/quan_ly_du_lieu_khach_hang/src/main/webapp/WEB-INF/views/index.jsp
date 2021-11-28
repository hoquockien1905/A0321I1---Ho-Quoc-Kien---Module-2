<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head th:replace="/layout :: head">
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h3>Customers</h3>
<p>
    <a th:href="@{/create}">Add new customer</a>
</p>
<div class="notify">
    <div th:if="${success}">
        <span th:text="${success}"></span>
    </div>
</div>
<table id="customers">
    <thead>
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>Edit</th>
        <th>Delete</th>
        <th>View</th>
    </tr>
    </thead>
    <tbody>
    <tr th:each="row,rowStat : ${customers}">
        <td th:text="${row.getName()}"></td>
        <td th:text="${row.getEmail()}"></td>
        <td th:text="${row.getAddress()}"></td>
        <td><a th:href="@{/{id}/edit(id=${row.getId()})}">Edit</a></td>
        <td><a th:href="@{/{id}/delete(id=${row.getId()})}">delete</a></td>
        <td><a th:href="@{/{id}/view(id=${row.getId()})}">view</a></td>
    </tr>
    </tbody>
</table>
<footer th:replace="/layout :: footer"></footer>
</body>
</html>