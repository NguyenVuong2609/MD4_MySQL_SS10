<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 5/5/2023
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<%!
  Map<String, String> dic = new HashMap<>();
%>

<%
  dic.put("hello", "Xin chào");
  dic.put("how", "Thế nào");
  dic.put("book", "Quyển vở");
  dic.put("computer", "Máy tính");
  dic.put("van ham", "Vân Hâm");

  String search = request.getParameter("search");

  String result = dic.get(search);
  PrintWriter printWriter = response.getWriter();
  if (result != null) {
    printWriter.write("<h1> Vietnamese: "+result+"</h1>");
    printWriter.write("<h1> English: "+search+"</h1>");
  } else {

    printWriter.write("<h1>Not Found</h1>");
  }
%>
</body>
</html>
