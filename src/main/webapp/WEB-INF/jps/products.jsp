<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 26.08.2017
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Show all products</title>
</head>
<body>
<div align="center">
    <table id="products">
        <caption><h1>List of all products</h1></caption>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Manufacturer</th>
            <th>Cost</th>
            <th>Description</th>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.manufacturer}</td>
                <td>${product.cost}</td>
                <td>${product.description}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
