<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/24/2025
  Time: 9:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Danh sách sản phẩm</h2>

<a href="add-product">Thêm mới sản phẩm</a>
<table border="1" width="60%">
    <thead>
    <tr>
        <th>STT</th>
        <th>Tên sản phẩm</th>
        <th>Giá</th>
        <th>Số lượng</th>
        <th>Hình ảnh</th>
        <th>Chức năng</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${empty products}">
        <tr style="text-align: center">
            <td colspan="6">Chưa có sản phẩm nào.</td>
        </tr>
    </c:if>

    <c:if test="${not empty products}">
        <c:forEach var="product" items="${products}" varStatus="loop">
            <tr style="text-align: center">
                <td>${loop.index + 1}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.quantity}</td>
                <td><img src="${product.image}" alt="" width="200" height="200"/></td>
                <td>
                    <form action="edit-product/${product.id}" method="get">
                        <button type="submit">Sửa</button>
                    </form>
                    <form action="delete-product/${product.id}" method="post">
                        <button type="submit" onclick="return confirm('Ban có chắc chắn xóa sản phẩm này?')">Xóa</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
</body>
</html>