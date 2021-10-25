<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 10/16/2021
  Time: 8:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Calculator</title>
  </head>
  <body>
  <h2>Simple Calculator</h2>
  <form action="calculator-servlet" method="post">
    <fieldset>
      <legend>
        Calculator
      </legend>
      <label>
        First operand:
        <input type="number" name="firstOpe">
      </label>
      <label>
        Operator:
        <select name="ope">
          <option value="+">Add</option>
          <option value="-">Sub</option>
          <option value="*">Mul</option>
          <option value="/">Div</option>
        </select>
      </label>
      <label>
        Second operand:
        <input type="number" name="secondOpe">
      </label>
      <input value="Calculate" type="submit"/>
    </fieldset>
  </form>
  <h2> Result: ${firstOpe} ${ope} ${secondOpe} = ${result}</h2>
  </body>
</html>
