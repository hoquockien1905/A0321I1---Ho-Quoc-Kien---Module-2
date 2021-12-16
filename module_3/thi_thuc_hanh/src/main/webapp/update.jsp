<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/assets/bootstrap413/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <form action="product?action=update&id=${benhAn.idBenhAn}" method="post">
        <div class="form-group">
            <label for="idBenhAn">Mã bệnh án</label>
            <input type="text" class="form-control" id="idBenhAn" name="idBenhAn" value="${benhAn.idBenhAn}" readonly>
        </div>
        <div class="form-group">
            <label for="idBenhNhan">Mã bệnh nhân</label>
            <input type="text" class="form-control" id="idBenhNhan" name="idBenhNhan" value="${benhAn.idBenhNhan}" readonly>
        </div>
        <div class="form-group">
            <label for="price">Giá</label>
            <input type="text" class="form-control" id="price" name="price">
        </div>
        <div class="form-group">
            <label for="price">Trạng thái</label>
            <select class="form-control" name="status" id="status">
                <option value="true">Còn hàng</option>
                <option value="false">Hết hàng</option>
            </select>
        </div>
        <div class="form-group">
            <label for="idCategory">Danh mục</label>
            <select class="form-control" name="idCategory" id="idCategory">
                <c:forEach items="${listCategory}" var="category">
                    <option value="${category.idCategory}">${category.nameCategory}</option>
                </c:forEach>
            </select>
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    <script src="/assets/jquery/jquery-3.5.1.min.js"></script>
    <script src="/assets/bootstrap413/js/popper.min.js"></script>
    <script src="/assets/datatables/js/dataTables.bootstrap4.min.js"></script>
    <script src="/assets/bootstrap413/js/bootstrap.min.js"></script>
    <script src="/assets/bootstrap413/js/bootstrap.bundle.js"></script>
</div>
</body>
</html>