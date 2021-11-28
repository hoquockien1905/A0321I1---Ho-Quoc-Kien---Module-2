<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head th:replace="/layout :: head"></head>
<body>
<h3>View Customer</h3>
<p>
    <a th:href="@{/}">
        Back to customer list
    </a>
</p>
<div class="detail">
    <div class="cusdetail" th:object="${customer}">
        <label>Name:</label>
        <label th:text="*{name}"></label>
    </div>
    <div class="cusdetail">
        <label>Email:</label>
        <label th:text="${customer.getEmail()}"></label>
    </div>
    <div class="cusdetail">
        <label>Address:</label>
        <label th:text="${customer.getAddress()}"></label>
    </div>
</div>
<footer th:replace="/layout :: footer"></footer>
</body>
</html>