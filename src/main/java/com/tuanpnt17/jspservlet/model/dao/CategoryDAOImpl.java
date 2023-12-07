/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuanpnt17.jspservlet.model.dao;

import com.tuanpnt17.jspservlet.model.dto.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

  @Override
  public Category getOne(int id) {
    PreparedStatement ps;
    ResultSet rs;
    try {
      String sql = "SELECT * FROM Categories WHERE id = ?";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, id);
      rs = ps.executeQuery();
      if (rs.next()) {
        return new Category(rs.getInt("id"),
                rs.getString("name"),
                rs.getString("describe"));
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    return null;
  }

  @Override
  public void persist(Category category) {
    PreparedStatement stm;
    ResultSet rs;
    try {
      String sql = "INSERT INTO Categories VALUES (?, ?, ?)";
      stm = conn.prepareStatement(sql);
      stm.setInt(1, category.getId());
      stm.setString(2, category.getName());
      stm.setString(3, category.getDescribe());
      stm.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e);
    }
  }

  @Override
  public void remove(int id) {
    PreparedStatement stm;
    ResultSet rs;
    try {
      String sql = "DELETE FROM Categories WHERE id = ?";
      stm = conn.prepareStatement(sql);
      stm.setInt(1, id);
      stm.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e);
    }
  }

  @Override
  public void update(Category category) {
    PreparedStatement stm;
    try {
      String sql = "UPDATE [dbo].[Categories]\n"
              + "   SET [name] = ?\n"
              + "      ,[describe] = ?\n"
              + " WHERE id = ?";
      stm = conn.prepareStatement(sql);
      stm.setString(1, category.getName());
      stm.setString(2, category.getDescribe());
      stm.setInt(3, category.getId());
      stm.executeUpdate();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

}
