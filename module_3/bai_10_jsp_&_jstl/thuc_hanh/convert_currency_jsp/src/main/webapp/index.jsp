<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 10/16/2021
  Time: 10:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Currency convert</title>
  </head>
  <body>
  <h2>Currency convert</h2>
  <form action="converter.jsp" method="post">
    <label>
      Rate:
      <input type="text" name="rate" placeholder="RATE" value="23000">
    </label> <br/>
    <label>
      USD:
      <input type="text" name="usd" placeholder="USD" value="0">
    </label> <br/>
    <button type="submit">Converter</button>
  </form>
  </body>
</html>
