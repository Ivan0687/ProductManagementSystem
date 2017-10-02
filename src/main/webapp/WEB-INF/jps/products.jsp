<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 26.08.2017
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Show all products</title>
    <link href="${pageContext.request.contextPath}/styles.css" rel="stylesheet">


</head>
<body>
<div align="center">
    <h2>Вы вошли как: <sec:authentication property="principal.username"/></h2>
    <h2>Registration date: <sec:authentication property="principal.registrationDate"/></h2>
    <h2>Email of user: <sec:authentication property="principal.email"/></h2>

    <c:set var="login">
        <sec:authentication property="principal.username"/>
    </c:set>
    <c:if test = "${'admin' eq login}">
         You are ADMIN
    </c:if>


    <table border="bold" id="products">
        <caption><h1>List of all products</h1></caption>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Manufacturer</th>
            <th>Cost</th>
            <th>Description</th>
            <sec:authorize access="hasRole('ADMIN')">
                <th>Update</th>
                <th>Delete</th>
            </sec:authorize>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.manufacturer}</td>
                <td>${product.cost}</td>
                <td>${product.description}</td>
                <sec:authorize access="hasRole('ADMIN')">
                    <td><form action="${pageContext.request.contextPath}/product/product_update/id=${product.id}" method="get">
                        <input type="submit" value="Update product">
                    </form></td>
                    <td><form action="${pageContext.request.contextPath}/product/product_delete/id=${product.id}" method="get">
                        <input type="submit" value="Delete product">
                    </form></td>
                </sec:authorize>
            </tr>
        </c:forEach>
    </table>
    <sec:authorize access="hasRole('ADMIN')">
        <div align="center">
            <form action="${pageContext.request.contextPath}/product/product_add" method="get">
                <input type="submit" value="Add product">
            </form>
        </div>
    </sec:authorize>
    <div align="center">
        <form action="${pageContext.request.contextPath}/logout" method="post">
            <input type="submit" value="Logout">
        </form>
    </div>
</div>
</body>
</html>
