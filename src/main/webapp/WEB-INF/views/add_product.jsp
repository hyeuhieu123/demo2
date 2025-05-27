<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Hoang
  Date: 5/25/2025
  Time: 9:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h2>Thêm mới sản phẩm</h2>
<form:form action="create-product" modelAttribute="product" method="post" enctype="multipart/form-data">
  <div>
    <p>Tên sản phẩm</p>
    <form:input path="name" placeholder="Nhập tên sản phẩm"/>
    <br>
    <form:errors path="name" cssStyle="color: red"/>
  </div>
  <div>
    <p>Giá</p>
    <form:input path="price" type="number" min="0"/>
  </div>
  <div>
    <p>Số lượng</p>
    <form:input path="quantity" type="number" min="0" value="0"/>
  </div>
  <div>
    <p>Hình ảnh</p>
    <form:input path="file" type="file"/>
    <br>
    <form:errors path="file" cssStyle="color: red"/>
  </div>
  <br>
  <button type="submit">Thêm</button>
</form:form>
</body>
</html>