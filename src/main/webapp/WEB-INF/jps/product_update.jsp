<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 27.08.2017
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Update product</title>
    <style>
        #products {
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 80%;
        }

        #products td, #products th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #products tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        #products tr:hover {
            background-color: #ddd;
        }

        #products th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #4CAF50;
            color: white;
        }
    </style>
</head>
<body>
<div align="center">
    <form action="/product/update" method="post">
        <input name="id" value="${product.id}" hidden>
        <table border="bold" id="products">
            <tr>
                <th></th>
                <th>Old product</th>
                <th>New product</th>
            </tr>
            <tr>
                <td>Name</td>
                <td>${product.name}</td>
                <td><input type="text" name="name" value="${product.name}"></td>
            </tr>
            <tr>
                <td>Manufacturer</td>
                <td>${product.manufacturer}</td>
                <td><input type="text" name="manufacturer" value="${product.manufacturer}"></td>
            </tr>
            </tr><tr>
                <td>Cost</td>
                <td>${product.cost}</td>
                <td><input type="number" name="dollars" value="${product.cost.intValue()}">dollars
                    <input type="number" name="cents" value="${product.cost.subtract(product.cost.intValue())*100}", maxlength="2">cents</td>
            </tr>
            <tr>
                <td>Description</td>
                <td>${product.description}</td>
                <td><input type="text" name="description" value="${product.description}"></td>
            </tr>
            <tr>
                <th><input type="submit" value="Update"></th>
                <th><input type="reset" name="Reset"></th>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
