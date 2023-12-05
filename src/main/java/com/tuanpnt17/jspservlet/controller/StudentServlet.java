/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tuanpnt17.jspservlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 *
 * @author TuanPNTSE173039
 */
public class StudentServlet extends HttpServlet {

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
      out.println("<title>Servlet StudentServlet</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Servlet StudentServlet at " + request.getContextPath() + "</h1>");
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
    request.getRequestDispatcher("StudentForm.html").forward(request, response);
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
    PrintWriter out = response.getWriter();
//    Enumeration paramNames = request.getParameterNames();
//    while (paramNames.hasMoreElements()) {
//      out.println(paramNames.nextElement());
//    }

    String firstName = request.getParameter("firstname");
    String lastName = request.getParameter("lastname");
    String gender = request.getParameter("gender");
    String mark = request.getParameter("mark");
    String subject = request.getParameter("subject");
    String subjectName = convertToSubjectName(subject);
    String output = "";
    try {
      double markNum = Double.parseDouble(mark);
      if (gender.equals("male")) {
        output += "Hello Mr." + firstName;
      } else {
        output += "Hello Miss." + lastName;
      }
      if (markNum >= 5) {
        output += ". Congratulation " + firstName + " passed " + subjectName;
      } else {
        output += ". So sorry, " + firstName + " failed " + subjectName;
      }
    } catch (NumberFormatException e) {
      System.out.println(e);
    }
    printScreen(out, output);
  }

  private void printScreen(PrintWriter out, String output) {
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Servlet CalcRectangle</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h2 style='color: green'>" + output + "</h2>");
    out.println("</body>");
    out.println("</html>");
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

  private String convertToSubjectName(String subject) {
    if (subject.equals("1")) {
      return "PRJ301";
    }
    if (subject.equals("2")) {
      return "JPD123";
    }
    return "PRN211";
  }

}
