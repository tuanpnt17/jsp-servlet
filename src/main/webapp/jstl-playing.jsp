<%--
    Document   : jstl-playing
    Created on : Dec 6, 2023, 7:38:50 PM
    Author     : TuanPNTSE173039
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <c:set var="name" value="${param.num}" />
    <h2><c:out value="${name}"/></h2>
  </body>
</html>
