<%--
    Document   : sum.jsp
    Created on : Dec 6, 2023, 7:09:39 PM
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
    <div style="max-width: 500px; margin: 0 auto">
      <h2>Sum of three number</h2>
      <form>
        Num1: <input type="text" name="num1" value="${param.num1}"><br/>
        Num2: <input type="text" name="num2" value="${param.num2}"><br/>
        Num3: <input type="text" name="num3" value="${param.num3}"><br/>
        <input type="submit" value="Calculate">
      </form>
      <hr/>
      <h2>Sum = ${param.num1 + param.num2 + param.num3}</h2>
    </div>
  </body>
</html>
