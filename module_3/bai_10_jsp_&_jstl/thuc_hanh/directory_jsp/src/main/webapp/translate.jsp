<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 10/16/2021
  Time: 5:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!
    Map<String, String> directory = new HashMap<>();
%>
<%
    directory.put("book", "sách");
    directory.put("english", "tiếng Anh");
    directory.put("sleep", "ngủ");
    directory.put("school", "trường");

    String search = request.getParameter("word").toLowerCase();
    String result = directory.get(search);
    PrintWriter writer = response.getWriter();
    if (result != null) {
        writer.println("<h1>Word: " + search + "</h1>");
        writer.println();
        writer.println("<h1>Resutl: " + result + "</h1>");
    } else {
        writer.println("Not found!");
    }
%>
</body>
</html>
