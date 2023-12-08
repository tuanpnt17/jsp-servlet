<%--
    Document   : signup
    Created on : Dec 8, 2023, 7:13:38 PM
    Author     : TuanPNTSE173039
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Register</title>
    <script src="https://cdn.tailwindcss.com"></script>

  </head>
  <body>

    <c:set var="failMessage" value="${requestScope.failMessage}" />
    <c:set var="failMatch" value="${requestScope.failMatch}" />

    <%@include file="header.jsp" %>
    <section class="bg-gray-50 mt-[45px]">
      <div class="flex flex-col items-center justify-center px-6 py-8 mx-auto md:h-screen lg:py-0">
        <div class="w-full bg-white rounded-lg shadow sm:max-w-md xl:p-0">
          <div class="p-6 space-y-4 md:space-y-6 sm:p-8">
            <h1 class="text-xl font-bold leading-tight tracking-tight text-gray-900 md:text-2xl">
              Create an account
            </h1>
            <c:if test="${failMessage != null}">
              <span class="block text-red-500 font-medium">${requestScope.failMessage}</span>
            </c:if>
            <form class="space-y-4 md:space-y-6" action="register" method="post">
              <div>
                <label for="username" class="block mb-2 text-sm font-medium text-gray-900">Username</label>
                <input type="text" value="${param.username}" name="username" id="username" class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 " placeholder="name@company" required>
              </div>
              <div>
                <label for="password" class="block mb-2 text-sm font-medium text-gray-900 ">Password</label>
                <input type="password" name="password" id="password" placeholder="••••••••" class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5" required>
              </div>

              <div>
                <label for="confirm" class="block mb-2 text-sm font-medium text-gray-900 ">Confirm Password</label>
                <c:if test="${failMatch != null}">
                  <span class="text-red-500 pl-2">${failMatch}</span>
                </c:if>
                <input type="password" name="confirm" id="confirm" placeholder="••••••••" class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5" required>
              </div>

              <button type="submit" class="w-full text-white bg-primary-600 hover:bg-primary-700 focus:ring-4 focus:outline-none focus:ring-primary-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center bg-blue-600 hover:bg-blue-400">Register</button>

            </form>
          </div>
        </div>
      </div>
    </section>
  </body>
</html>
