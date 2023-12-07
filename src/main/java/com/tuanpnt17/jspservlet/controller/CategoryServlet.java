/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tuanpnt17.jspservlet.controller;

import com.tuanpnt17.jspservlet.model.dto.Category;
import com.tuanpnt17.jspservlet.service.CategoryService;
import com.tuanpnt17.jspservlet.service.CategoryServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author TuanPNTSE173039
 */
@WebServlet(name = "CategoryServlet", urlPatterns = {"/category"})
public class CategoryServlet extends HttpServlet {

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
      /* TODO output your page here. You may use following sample code. */
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet CategoryServlet</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Servlet CategoryServlet at " + request.getContextPath() + "</h1>");
      out.println("</body>");
      out.println("</html>");
    }
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    CategoryService categoryService = CategoryServiceImpl.getInstance();
    List<Category> list = categoryService.getCategoryList();
    request.setAttribute("data", list);
    request.getRequestDispatcher("home.jsp").forward(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String idStr = request.getParameter("id");
    String name = request.getParameter("name");
    String describe = request.getParameter("describe");
    CategoryService categoryService = CategoryServiceImpl.getInstance();
    try {
      int id = Integer.parseInt(idStr);
      boolean isSuccess = categoryService.addNewCategory(new Category(id, name, describe));
      if (isSuccess) {
        doGet(request, response);
      } else {
        request.setAttribute("duplicateID", "ID is already existed!!!");
        request.getRequestDispatcher("add.jsp").forward(request, response);
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

  public static void main(String[] args) {
    CategoryService categoryService = CategoryServiceImpl.getInstance();
    List<Category> list = categoryService.getCategoryList();

    list.stream().forEach(System.out::println);
  }
}
