<%--
    Document   : jstl-playing
    Created on : Dec 6, 2023, 7:38:50 PM
    Author     : TuanPNTSE173039
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <c:set var="num" value="${param.num}" />
    <h2><c:out value="${num}"/></h2>

    <h3><fmt:formatNumber pattern="##.##" value="${Math.PI}"/></h3>
    <h3>Today <fmt:formatDate pattern="dd/MM/yyyy" value="<%= new java.util.Date() %>"/></h3>

    <form>
      <input type="text" name="username" >
      <input type="submit" value="Get">
    </form>

    <hr/>
    <c:set var="username" value="${param.username}"/>
    <h3>Hello ${username} and in uppercase ${fn:toUpperCase(username)} with ${fn:length(username)} letters </h3>
  </body>
</html>
