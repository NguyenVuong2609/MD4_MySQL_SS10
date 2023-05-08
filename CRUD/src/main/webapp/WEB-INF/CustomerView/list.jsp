<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 5/8/2023
  Time: 10:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        tr,td {
            border: darksalmon 1px solid;
            text-align: center;
        }
    </style>
</head>
<body>
<h1 style="text-align: center">================= CUSTOMER MANAGE =================</h1>
<a href="customer?action=create">Create Customer</a>
<table style="border: darksalmon 1px solid; width: 100%; border-collapse: collapse">
    <tr>
        <td>No.</td>
        <td>Name</td>
        <td>Mail</td>
        <td>Address</td>
    </tr>
    <c:forEach items='${requestScope["customerList"]}' var="ctm">
        <tr>
            <td>${ctm.getId()}</td>
            <td>${ctm.getName()}</td>
            <td>${ctm.getMail()}</td>
            <td>${ctm.getAddress()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
