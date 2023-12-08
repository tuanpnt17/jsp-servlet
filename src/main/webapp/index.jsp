<%--
    Document   : index
    Created on : Dec 7, 2023, 3:38:46 PM
    Author     : TuanPNTSE173039
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Product List</title>
    <script src="https://cdn.tailwindcss.com"></script>

  </head>
  <body>
    <c:set var="cLsit" value="${sessionScope.cList}"/>
    <c:set var="pList" value="${requestScope.pList}"/>
    <div class="max-w-[1240px] m-auto p-4">
      <%@include file="header.jsp" %>
      <div class="header flex justify-center items-center fixed top-[44px] left-0 right-0 bg-white">
        <ul class="header__list flex justify-center gap-x-7">
          <li class="header__item hover:text-orange-500 transition-all cursor-pointer text-xl font-bold py-2">
            <a href="product-list">All</a>
          </li>
          <c:forEach items="${cList}" var="c">
            <li class="header__item hover:text-orange-500 transition-all cursor-pointer text-xl font-bold py-2">
              <a href="product-list?cid=${c.id}">${c.name}</a>
            </li>
          </c:forEach>
        </ul>
      </div>

      <div class="wrapper flex justify-center mt-[100px]">
        <div class="sidebar w-[25%]">
          <form action="product-list">
            <div class="category mb-3">
              <label for="category" class="inline-block text-2xl text-center mb-1 relative left-[50%] translate-x-[-50%] border-b-2 border-orange-500 pb-1">
                Category
              </label>
              <select name="cid" id="category" class="block w-full border-2 p-2 rounded-md">
                <option value="">All</option>
                <c:forEach items="${cList}" var="c">
                  <option ${param.cid==c.id ? 'selected' : ''}  value="${c.id}">${c.name}</option>
                </c:forEach>
              </select>
            </div>

            <div class="search mb-3">
              <label for="search"  class="inline-block text-2xl text-center mb-1 relative left-[50%] translate-x-[-50%] border-b-2 border-orange-500 pb-1">Search</label>
              <input type="text" value="${param.key}" name="key" id="search" placeholder="Name/Describe" class="p-2 w-full border-2 rounded-md">
            </div>

            <div class="price mb-3">
              <h2 class="inline-block text-2xl text-center mb-1 relative left-[50%] translate-x-[-50%] border-b-2 border-orange-500 pb-1">Price</h2>
              <div class="flex justify-between gap-3">
                <label for="from-price" class="w-[50%] cursor-pointer ">From</label>
                <label for="to-price" class="w-[50%] cursor-pointer">To</label>
              </div>
              <div class="flex justify-between gap-3">
                <input type="text" value="${param.fromprice}" name="fromprice" id="from-price" class="block border-2 rounded-md p-2 w-[50%]">
                <input type="text" value="${param.toprice}" name="toprice" id="to-price" class="block border-2 rounded-md p-2 w-[50%]">
              </div>
            </div>

            <div class="date mb-3">
              <h2 class="inline-block text-2xl text-center mb-1 relative left-[50%] translate-x-[-50%] border-b-2 border-orange-500 pb-1">Date</h2>
              <div class="flex justify-between gap-3">
                <label for="from-date" class="w-[50%] cursor-pointer">From</label>
                <label for="to-date" class="w-[50%] cursor-pointer">To</label>
              </div>
              <div class="flex justify-between gap-3">
                <input type="date" value="${param.fromdate}" name="fromdate" id="from-date" class="block border-2 rounded-md p-2 w-[50%]">
                <input type="date" value="${param.todate}" name="todate" id="to-date" class="block border-2 rounded-md p-2 w-[50%]">
              </div>
            </div>
            <input type="submit" value="Search" class="block w-full bg-orange-500 text-white text-xl py-3 mt-5 rounded-md hover:bg-orange-600 transition-all cursor-pointer">
          </form>
        </div>
        <div class="content w-[75%]">
          <div class="product-list flex flex-wrap justify-evenly">
            <c:if test="${pList.isEmpty()}">
              <div class="product-item w-[200px] p-2 mb-4">Empty List</div>
            </c:if>
            <c:if test="${pList.size() > 0}">
              <c:forEach var="p" items="${pList}">
                <div class="product-item w-[300px] p-2 mb-4">
                  <div class="product__img flex justify-center items-center">
                    <img src="${p.image}" alt="" class="block">
                  </div>
                  <div class="product__title text-center text-2xl font-semibold mt-2">${p.name}</div>
                  <div class="product__price text-center">${p.price} vnd</div>
                  <div class="product__price text-center"><fmt:formatDate pattern="dd/MM/yyyy" value="${p.releaseDate}"/></div>
                </div>
              </c:forEach>
            </c:if>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
