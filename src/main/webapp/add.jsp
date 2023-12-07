<%--
    Document   : add
    Created on : Dec 7, 2023, 9:52:34 AM
    Author     : TuanPNTSE173039
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add an Category</title>
    <script src="https://cdn.tailwindcss.com"></script>

  </head>
  <body>
    <div class="m-auto max-w-[500px] p-3 mt-3">
      <h2 class="mb-3 text-center text-3xl font-medium uppercase">Add New Category</h2>
      <form action="list" method="post" class="grid grid-cols-1">
        <div class="sm:col-span-3 mb-4">
          <label for="c-id" class="block text-sm font-medium leading-6 text-gray-900">Category ID <span class="text-red-500 ml-2">${requestScope.duplicateID}</span></label>
          <div class="mt-2">
            <input type="number" name="id" value="${param.id}" id="c-id" autocomplete="given-name" required class="px-2 block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6" />
          </div>
        </div>

        <div class="sm:col-span-3 mb-4">
          <label for="c-name" class="block text-sm font-medium leading-6 text-gray-900">Category Name</label>
          <div class="mt-2">
            <input type="text" name="name" value="${param.name}" id="c-name" autocomplete="family-name" class="px-2 block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6" />
          </div>
        </div>

        <div class="sm:col-span-3 mb-4">
          <label for="c-describe" class="block text-sm font-medium leading-6 text-gray-900">Category Describe</label>
          <div class="mt-2">
            <input type="text" name="describe" value="${param.describe}" id="c-describe" autocomplete="family-name" class="px-2 block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6" />
          </div>
        </div>

        <div>
          <input type="submit" value="Save" class="inline-block bg-green-400 px-5 py-2 rounded-lg hover:bg-green-300 transition-all cursor-pointer">
          <a href="list" class="inline-block bg-red-400 px-5 py-2 rounded-lg  hover:bg-red-300 transition-all cursor-pointer">Cancle</a>

        </div>
      </form>
    </div>
  </body>
</html>
