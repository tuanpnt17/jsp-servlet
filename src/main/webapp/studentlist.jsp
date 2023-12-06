<%--
    Document   : studentlist
    Created on : Dec 6, 2023, 11:03:29 AM
    Author     : TuanPNTSE173039
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.tuanpnt17.jspservlet.service.StudentList" %>
<%@page import="com.tuanpnt17.jspservlet.model.Student" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Student list</title>
    <style>
      table, th, td {
        border-collapse: collapse;
        border: 1px solid #333;
      }
    </style>
  </head>
  <body>
    <h1>Welcome to Student list</h1>
    <table>
      <tr>
        <th>Student ID</th>
        <th>Name</th>
        <th>YOB</th>
        <th>Gender</th>
      </tr>
      <%
        if (request.getAttribute("sList") != null) {
          StudentList l = (StudentList) request.getAttribute("sList");
          for(Student s : l) {
      %>
      <tr>
        <td><%= s.getId()%></td>
        <td><%= s.getName()%></td>
        <td><%= s.getYob()%></td>
        <td><img src=<%="./images/" + ((s.isGender()) ? "male.png" : "female.png") %> alt="xxx"/></td>
      </tr>
      <%
          }
        }
      %>


    </table>
  </body>
</html>
