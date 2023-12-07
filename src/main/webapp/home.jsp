<%--
    Document   : home
    Created on : Dec 6, 2023, 9:40:05 PM
    Author     : TuanPNTSE173039
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Category List</title>
    <script src="https://cdn.tailwindcss.com"></script>

  </head>
  <body>
    <div class="m-auto max-w-[1024px] p-3">
      <h1 class="mb-3 text-center text-3xl font-medium uppercase">The list of categories</h1>
      <a href="add.jsp" class="relative left-[50%] mb-5 inline-block translate-x-[-50%] rounded-md bg-red-300 p-2 transition-all hover:bg-blue-400">Add New Category</a>
      <table class="min-w-full table-auto text-center text-sm font-light">
        <thead class="border-b bg-neutral-800 font-medium text-white">
          <tr>
            <th scope="col" class="px-6 py-4">ID</th>
            <th scope="col" class="px-6 py-4">Name</th>
            <th scope="col" class="px-6 py-4">Describe</th>
            <th scope="col" class="px-6 py-4">Action</th>
          </tr>
        </thead>
        <tbody>
          <c:set var="cList" value="${requestScope.data}" />
          <c:forEach var="category" items="${cList}">
            <tr class="border-b dark:border-neutral-500">
              <td class="whitespace-nowrap px-6 py-4 font-medium">${category.id}</td>
              <td class="whitespace-nowrap px-6 py-4 font-normal">${category.name}</td>
              <td class="whitespace-pre-wrap px-6 py-4 font-normal min-w-[100px]">${category.describe}</td>
              <td class="whitespace-nowrap px-1 py-4 max-w-[100px]">
                <a href="update?id=${category.id}" class="mr-1 rounded-lg bg-green-400 px-3 py-2 text-base font-normal transition-all hover:bg-green-700 hover:text-white">Update</a>
                <a href="#" onclick="doDelete('${category.id}')" class="rounded-lg bg-red-600 px-3 py-2 text-base font-normal transition-all hover:bg-red-400 hover:text-white">Delete</a>
              </td>
            </tr>
          </c:forEach>

        </tbody>
      </table>
    </div>
    <script>
      function doDelete(id) {
        if (confirm("Do you want to DELETE the category with id: " + id)) {
          window.location = "delete?id=" + id;
        }
      }
    </script>
  </body>
</html>
