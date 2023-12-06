<%--
    Document   : disk
    Created on : Dec 6, 2023, 9:51:16 AM
    Author     : TuanPNTSE173039
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Disk</title>
  </head>
  <body>
    <h1>Welcome to Disk.jsp</h1>
    <form action="calc" method="post">
      <label for="radius">Input radius: </label> <input type="text" id="radius" name="r"> <br/>
      <input type="submit" value="Calculate">
    </form>

    <%
      if (request.getAttribute("result") != null) {
        double area = (double) request.getAttribute("result");
    %>
    <h3>Area: <%= area%></h3>
    <%
      }
    %>
  </body>
</html>
