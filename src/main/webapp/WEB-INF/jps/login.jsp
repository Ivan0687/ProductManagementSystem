<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 26.08.2017
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Product management system</title>
</head>
<body>
<div align="center">
    <form action="login" method="post">
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
    <form action="/registration" method="get">
        <input type="submit" value="Registration">
    </form>
</div>
</body>
</html>
