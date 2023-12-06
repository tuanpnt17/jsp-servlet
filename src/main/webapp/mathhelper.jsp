<%--
    Document   : mathhelper
    Created on : Dec 6, 2023, 4:08:01 PM
    Author     : TuanPNTSE173039
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Math helper</title>
    <script src="https://cdn.tailwindcss.com"></script>

  </head>
  <body>
    <div class="container bg-slate-300 mx-auto max-w-sm mt-5">
      <h2 class="text-center text-2xl py-5 border-b border-cyan-600">A simple calculator</h2>
      <form class="p-4">
        <div class="flex justify-between items-center mb-3">
          <label for="num1">Enter Operand 1: </label>
          <input type="text" id="num1" name="num1" class="flex-1 ml-5 p-1"
                 value="<%= request.getParameter("num1") != null ? request.getParameter("num1") : "" %>">
        </div>
        <div class="flex justify-between items-center mb-3">
          <label for="num1">Enter Operand 2: </label>
          <input type="text" id="num1" name="num2" class="flex-1 ml-5 p-1"
                 value="<%= request.getParameter("num2") != null ? request.getParameter("num2") : "" %>">
        </div>
        <div class="flex justify-between items-center mb-3">
          <label for="op">Operation</label>
          <select id="op" name="op" class="flex-1 ml-5 p-1" >
            <option value="add">+</option>
            <option value="sub">-</option>
            <option value="mul">*</option>
            <option value="div">/</option>
          </select>
        </div>
        <input type="submit" value="Calculate" class="bg-slate-500 text-red-100 p-3 hover:bg-cyan-700 cursor-pointer inline-block relative left-[50%] translate-x-[-50%]">
      </form>
      <hr/>
      <h2 class="text-center p-2 text-xl">
        <jsp:useBean id="m" class="com.tuanpnt17.jspservlet.model.MathHelper"/>
        <jsp:setProperty name="m" property="*"/>
        <jsp:getProperty name="m" property="result"/>
      </h2>
    </div>
  </body>
</html>
