
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Discount Calculator</title>
</head>
<body>
<form action="display-discount">
    <h3>Product Discount Calculator</h3>
    <label>
        Product Description:
        <input type="text" name="description">
    </label> <br/>
    <label>
        List Price:
      <input type="number" name="price">
    </label> <br/>
  <label>
    Discount Percent:
    <input type="text" placeholder="%" name="percent">
  </label> <br/>
  <button formmethod="post">Calculate Discount</button>
</form>
</body>
</html>
