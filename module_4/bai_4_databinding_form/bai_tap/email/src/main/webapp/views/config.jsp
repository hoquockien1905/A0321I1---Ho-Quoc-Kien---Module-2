<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 12/1/2021
  Time: 12:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Configuration</title>
</head>
<body>
<h1>Setting</h1>
<form:form method="post" action="" modelAttribute="email">
    <table>
        <tr>
            <td>Languages:</td>
            <td>
                <form:select path="languages">
                    <form:options items="${languages}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Page Size:</td>
            <td>
                Show
                <form:select path="pageSize">
                    <form:options items="${pageSizeList}"/>
                </form:select>
                emails per page
            </td>
        </tr>
        <tr>
            <td>Spams filter:</td>
            <td>
                <form:checkbox path="spamsFilter"/>
                Enable spams filter
            </td>
        </tr>
        <tr>
            <td>Signature:</td>
            <td>
                <form:textarea path="signature" />
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Update"/>
                <a href="">Cancel</a>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
