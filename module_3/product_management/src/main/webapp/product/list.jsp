<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/assets/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/datatables/css/dataTables.bootstrap4.min.css">

</head>
<body>
<div class="container">
    <table id="product" class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Mã sản phẩm</th>
            <th scope="col">Tên sản phẩm</th>
            <th scope="col">Giá</th>
            <th scope="col">Trạng thái</th>
            <th scope="col">Danh mục</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.status ? "Còn hàng" : "Hết hàng"}</td>
                <td>${product.nameCategory}</td>
                <td>
                    <button type="button" class="btn btn-danger" onclick="setValueForm('${product.id}')"
                            data-toggle="modal" data-target="#deleteModal">
                        Xóa
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <button><a href="product?action=create">Thêm sản phẩm</a></button>

    <!-- Modal -->
    <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="product?action=delete" method="post">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Bạn có chắc muốn xóa không?</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <input name="idProduct" id="idProduct" hidden>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Dóng</button>
                        <button type="submit" class="btn btn-danger">Xóa</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <script src="/assets/jquery/jquery-3.5.1.min.js"></script>
    <script src="/assets/bootstrap413/js/popper.min.js"></script>
    <script src="/assets/datatables/js/jquery.dataTables.min.js"></script>
    <script src="/assets/datatables/js/dataTables.bootstrap4.min.js"></script>
    <script src="/assets/bootstrap413/js/bootstrap.min.js"></script>
    <script src="/assets/bootstrap413/js/bootstrap.bundle.js"></script>
    <script>
        $(document).ready(function () {
            $("#product").dataTable({
                "dom": "lrtip",
                "lengthChange": false,
                "pageLength": 5
            })
        })
    </script>
    <script>
        function setValueForm(idProduct) {
            document.getElementById("idProduct").value = idProduct;
        }
    </script>
</div>
</body>
</html>
