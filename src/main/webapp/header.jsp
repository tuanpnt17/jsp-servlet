<%--
    Document   : header
    Created on : Dec 8, 2023, 8:01:31 PM
    Author     : TuanPNTSE173039
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>a</title>
    <script src="https://cdn.tailwindcss.com"></script>

  </head>
  <body>
    <c:set var="a" value="${sessionScope.account}" />
    <div class="fixed left-0 right-0 top-0  bg-orange-300 p-2">
      <div class="flex justify-between m-auto max-w-[1024px]">
        <div class="text-xl font-semibold text-yellow-950"><a href="welcome.jsp">let-it-bee</a></div>
        <div>
          <c:if test="${a == null}">
            <div class="flex gap-3">
              <div class="hover:underline transition-all"><a href="login">Sign in</a></div>
              <div class="hover:underline transition-all"><a href="register">Sign up</a></div>
            </div>
          </c:if>
          <c:if test="${a != null}">
            <div class="flex gap-3">
              <div class="text-red-800">Hello, ${a.username}</div>
              <div class="hover:underline transition-all"><a href="logout">Logout</a></div>
            </div>
          </c:if>
          <!-- <div>
          <div>TuanPham</div>
          <div>Logout</div>
        </div> -->
        </div>
      </div>
    </div>
  </body>
</html>
