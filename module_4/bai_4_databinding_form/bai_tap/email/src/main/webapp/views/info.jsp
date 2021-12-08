<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 12/1/2021
  Time: 5:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Config Info</title>
</head>
<body>
<table border="1">
    <tr>
        <td>Languages: ${email.languages}</td>
    </tr>
    <tr>
        <td>Page Size: ${email.pageSize}</td>
    </tr>
    <tr>
        <td>Spams filter: ${email.spamsFilter}</td>
    </tr>
    <tr>
        <td>Signature: <b>Author</b>${email.signature}</td>
    </tr>
</table>
</body>
</html>
