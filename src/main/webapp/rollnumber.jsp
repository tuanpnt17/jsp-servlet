<%--
    Document   : rollnumber
    Created on : Dec 6, 2023, 10:03:34 AM
    Author     : TuanPNTSE173039
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Ex2 Roll Number</title>
  </head>
  <body>
    <%
      String myRollNumber = "SE173039";
//      request.setAttribute("myRN", myRollNumber);

    %>
    <h1><%= myRollNumber%></h1>
    <form action="roll" method="post">
      <label for="letter">Get first: </label><input type="text" id="letter" name="num"> letter(s)
      <input type="submit" value="Get">
    </form>

    <%
      if (request.getAttribute("result") != null) {
        String result = (String) request.getAttribute("result");
    %>
    <h3 style="color: brown"><%= result%></h3>
    <%
      }
    %>
  </body>
</html>
