<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 26.08.2017
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Product management system</title>
</head>
<body>
<h1>AAAAAAAAAAAAAAAAAAAAAAAA</h1>
<div align="center">
    <c:url value="j_spring_security_check" var="loginUrl"/>
    <form action="${loginUrl}" method="post">
        <table align="center">
            <tr>
                <th>Enter login</th>
                <td>
                    <input type="text" name="j_username" placeholder="Login">
                </td>
            </tr>
            <tr>
                <th>Enter login</th>
                <td>
                    <input type="password" name="j_password" placeholder="Password">
                </td>
            </tr>
            <tr align="center">
                <td>
                    <button type="submit">Enter</button>
                </td>
            </tr>
        </table>
    </form>
</div>
<div align="center">
    <form action="/registration" method="get">
        <input type="submit" value="Registration">
    </form>
</div>
</body>
</html>
