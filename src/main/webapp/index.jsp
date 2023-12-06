<%--
    Document   : index
    Created on : Dec 6, 2023, 9:20:02 AM
    Author     : TuanPNTSE173039
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.text.DecimalFormat" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Index</title>
  </head>
  <body>
    <% DecimalFormat f = new DecimalFormat(".##"); %>

    <h1>Hello World!</h1>
    <h3>Time: <%= f.format(Math.PI) %></h3>
  </body>
</html>
