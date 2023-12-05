/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tuanpnt17.jspservlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author TuanPNTSE173039
 */
public class CalcRectangle extends HttpServlet {

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
      out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
      out.println("<title>Servlet CalcRectangle</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Servlet CalcRectangle at " + request.getContextPath() + "</h1>");
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
    request.getRequestDispatcher("rectangle.html").forward(request, response);
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
    String heightRaw = request.getParameter("height");
    String widthRaw = request.getParameter("width");
    String[] checkBoxValue = request.getParameterValues("calcType");
    double height, width;
    String output;
    PrintWriter out = response.getWriter();
    try {
      height = Double.parseDouble(heightRaw);
      width = Double.parseDouble(widthRaw);
      output = calculateService(height, width, checkBoxValue);
      printScreen(out, output);
    } catch (NumberFormatException e) {
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

  private String calculateService(double height, double width, String[] checkBoxValue) {
    if (height <= 0) {
      return "<h2 style='color: red'>Height must not be less than or equal to 0</h2>";
    }
    if (width <= 0) {
      return "<h2 style='color: red'>Width must not be less than or equal to 0</h2>";
    }
    if (checkBoxValue == null) {
      return "<h2 style='color: red'>Chưa chọn check box</h2>";
    }
    if (checkBoxValue.length == 2) {
      return "<h2 style='color: blue'>Chu vi: " + calcChuvi(height, width) + "</h2>\n"
              + "<h2 style='color: orange'>Dien tich: " + calcDienTich(height, width) + "</h2>";
    }
    if (checkBoxValue[0].equalsIgnoreCase("chuvi")) {
      return "<h2 style='color: blue'>Chu vi: " + calcChuvi(height, width) + "</h2>";
    }
    return "<h2 style='color: orange'>Dien tich: " + calcDienTich(height, width) + "</h2>";
  }

  private void printScreen(PrintWriter out, String output) {
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Servlet CalcRectangle</title>");
    out.println("</head>");
    out.println("<body>");
    out.println(output);
    out.println("</body>");
    out.println("</html>");
  }

  private double calcChuvi(double height, double width) {
    return (height + width) * 2;
  }

  private double calcDienTich(double height, double width) {
    return height * width;
  }

}
