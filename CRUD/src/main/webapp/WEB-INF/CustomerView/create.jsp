<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 5/8/2023
  Time: 11:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center">==== FORM CREATE CUSTOMER ====</h1>
<c:if test="${requestScope['validate'] != null}">
    <label>${requestScope['validate']}</label>
</c:if>
<a href="customer">Back</a>
<form method="post">
    <table>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" name="address"></td>
        </tr>
    </table>
    <button type="submit">Create</button>
</form>
</body>
</html>
