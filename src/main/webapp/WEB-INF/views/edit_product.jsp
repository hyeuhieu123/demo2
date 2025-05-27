<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hoang
  Date: 5/25/2025
  Time: 9:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Cập nhật sản phẩm</h2>
<form:form action="${pageContext.request.contextPath}/update-product" modelAttribute="product" method="post" enctype="multipart/form-data">
    <div>
        <p>Tên sản phẩm</p>
        <form:input path="id" type="hidden"/>
        <form:input path="name" placeholder="Nhập tên sản phẩm" value="${product.name}"/>
        <br>
        <form:errors path="name" cssStyle="color: red"/>
    </div>
    <div>
        <p>Giá</p>
        <form:input path="price" type="number" min="0" value="${product.price}"/>
    </div>
    <div>
        <p>Số lượng</p>
        <form:input path="quantity" type="number" min="0" value="${product.quantity}"/>
    </div>
    <div>
        <c:if test="${not empty product.image}">
            <p>Ảnh hiện tại:</p>
            <img src="${product.image}" width="150" alt=""/>
        </c:if>
        <br>
        <form:input path="file" type="file"/>
    </div>
    <br>
    <button type="submit">Cập nhật</button>
</form:form>
</body>
</html>