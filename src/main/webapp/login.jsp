<%--
    Document   : login
    Created on : Dec 8, 2023, 5:05:37 PM
    Author     : TuanPNTSE173039
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
    <script src="https://cdn.tailwindcss.com"></script>

  </head>
  <body>
    <%@include file="header.jsp" %>
    <section class="bg-gray-50 mt-[45px]">
      <div class="flex flex-col items-center justify-center px-6 py-8 mx-auto md:h-screen lg:py-0">
        <div class="w-full bg-white rounded-lg shadow sm:max-w-md xl:p-0">
          <div class="p-6 space-y-4 md:space-y-6 sm:p-8">
            <h1 class="text-xl font-bold leading-tight tracking-tight text-gray-900 md:text-2xl">
              Sign in to your account
            </h1>
            <span class="block text-red-500 font-medium">${requestScope.failMessage}</span>
            <form class="space-y-4 md:space-y-6" action="login" method="post">
              <div>
                <label for="username" class="block mb-2 text-sm font-medium text-gray-900">Username</label>
                <input type="text" name="username" id="username" class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 " placeholder="name@company" required>
              </div>
              <div>
                <label for="password" class="block mb-2 text-sm font-medium text-gray-900 ">Password</label>
                <input type="password" name="password" id="password" placeholder="••••••••" class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5" required>
              </div>
              <div class="flex items-center justify-between">
                <div class="flex items-start">
                  <div class="flex items-center h-5">
                    <input id="remember" aria-describedby="remember" type="checkbox" class="w-4 h-4 border border-gray-300 rounded bg-gray-50 focus:ring-3 focus:ring-primary-300">
                  </div>
                  <div class="ml-3 text-sm">
                    <label for="remember" class="text-gray-500 ">Remember me</label>
                  </div>
                </div>
                <a href="#" class="text-sm font-medium text-primary-600 hover:underline ">Forgot password?</a>
              </div>
              <button type="submit" class="w-full text-white bg-primary-600 hover:bg-primary-700 focus:ring-4 focus:outline-none focus:ring-primary-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center bg-blue-600 hover:bg-blue-400">Sign in</button>
              <p class="text-sm font-light text-gray-500 dark:text-gray-400">
                Don’t have an account yet?
                <a href="register" class="font-medium text-primary-600 hover:underline dark:text-primary-500">
                  Sign up
                </a>
              </p>
            </form>
          </div>
        </div>
      </div>
    </section>
  </body>
</html>
