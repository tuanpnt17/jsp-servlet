<%--
    Document   : welcome
    Created on : Dec 8, 2023, 5:46:00 PM
    Author     : TuanPNTSE173039
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <script src="https://cdn.tailwindcss.com"></script>

  </head>
  <body>
    <%@include file="header.jsp" %>
    <div class="mx-auto max-w-[1024px] mt-[45px] ">
      <h1 class="text-center text-2xl font-medium">Home page</h1>
      <a href="category" class="text-orange-500">Back to category</a> <br>
      <a href="product-list" class="text-orange-500">Product list</a>
    </div>
  </body>
</html>
