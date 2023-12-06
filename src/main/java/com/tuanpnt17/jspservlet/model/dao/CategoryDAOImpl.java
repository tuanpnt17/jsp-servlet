/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuanpnt17.jspservlet.model.dao;

import com.tuanpnt17.jspservlet.model.dto.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TuanPNTSE173039
 */
public class CategoryDAOImpl implements CategoryDAO {

  private static CategoryDAO instance;
  private Connection conn = DBContext.makeConnection();

  private CategoryDAOImpl() {

  }

  public static CategoryDAO getInstance() {
    if (instance == null) {
      instance = new CategoryDAOImpl();
    }
    return instance;
  }

  @Override
  public List<Category> getAll() {
    PreparedStatement stm;
    ResultSet rs;

    List<Category> categoryList = new ArrayList<>();
    try {
      String sql = "SELECT * FROM Categories";
      stm = conn.prepareStatement(sql);
      rs = stm.executeQuery();

      while (rs.next()) {
        categoryList.add(new Category(
                rs.getInt("ID"),
                rs.getString("name"),
                rs.getString("describe")));
      }
    } catch (Exception e) {
      Logger.getLogger(CategoryDAOImpl.class.getName()).log(Level.SEVERE, null, e);
    }
    return categoryList;
  }

}
