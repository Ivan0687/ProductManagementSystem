<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 26.08.2017
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Product management system</title>
</head>
<body>

<div align="center">
    <sec:authorize access="isAuthenticated()">
        <h1>You are authorized</h1>
    </sec:authorize>

    <sec:authorize access="isAnonymous()">
        <h1>You are not authorized</h1>
    </sec:authorize>
</div>

<div align="center">
    <form action="${pageContext.request.contextPath}/login" method="post">
        <table align="center">
            <tr>
                <th>Enter login</th>
                <td>
                    <input autofocus type="text" name="username" placeholder="Login">
                </td>
            </tr>
            <tr>
                <th>Enter login</th>
                <td>
                    <input type="password" name="password" placeholder="Password">
                </td>
            </tr>
            <tr>
                <td align="center">
                    <button type="submit">Enter</button>
                </td>
            </tr>
        </table>
    </form>
</div>
<div align="center">
    <form action="${pageContext.request.contextPath}/registration" method="get">
        <input type="submit" value="Registration">
    </form>
</div>
</body>
</html>
