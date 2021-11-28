<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head th:replace="/layout :: head"></head>
<body>
<h3>Remove Customer</h3>
<p>
    <a th:href="@{/}">
        Back to customer list
    </a>
</p>
<div id="form">
    <form action="#" th:action="@{/delete}" th:object="${customer}"
          method="POST" novalidate="novalidate">
        <input type="hidden" th:field="*{id}"/>
        <div>
            <label>Name</label>
            <input type="text" th:field="*{name}"/>
        </div>
        <div>
            <label>Email</label>
            <input type="email" th:field="*{email}"/>
        </div>
        <div>
            <label>Address</label>
            <input type="text" th:field="*{address}"/>
        </div>
        <input type="submit" value="Remove">
    </form>
</div>
<footer th:replace="/layout :: footer"></footer>
</body>
</html>