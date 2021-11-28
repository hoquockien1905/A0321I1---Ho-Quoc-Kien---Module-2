<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 11/25/2021
  Time: 8:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Directory</title>
</head>
<body>
<h3>Translate to vietnamese</h3>
<form action="/" method="post">
    <input type="text" name="eng" value="${eng}">
    <button type="submit">translate</button>
</form>
<h3>${result}</h3>
</body>
</html>
