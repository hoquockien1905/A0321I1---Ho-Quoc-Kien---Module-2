<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head th:replace="/layout :: head"></head>
<body>
<div id="form">
    <form action="#" th:action="@{/save}" th:object="${customer}" method="post" novalidate="novalidate">
        <input type="hidden" th:field="*{id}">
        <div>
            <lable>Name</lable>
            <input type="text" th:field="*{name}">
        </div>
        <div>
            <label>Email</label>
            <input type="email" th:field="*{email}"/>
        </div>
        <div>
            <label>Address</label>
            <input type="text" th:field="*{address}"/>
        </div>
        <input type="submit" value="Save">
    </form>
</div>
<footer th:replace="/layout :: footer"></footer>
</body>
</html>