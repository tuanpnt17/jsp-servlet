<%--
    Document   : area
    Created on : Dec 6, 2023, 7:18:10 PM
    Author     : TuanPNTSE173039
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>

    <form action="calc" method="post">
      <label>Nhập chiều dài: </label>
      <input type="number" name="height"><br>
      <label>Nhập chiều rộng: </label>
      <input type="number" name="width"><br>
      <input type="submit" value="Calc Area">
    </form>
    <hr/>
    <h3>Area = ${requestScope.result}</h3>
    <h2>Init Pram ${initParam.user}</h2>
    <h2>Init Pram ${initParam.pass}</h2>

  </body>
</html>
