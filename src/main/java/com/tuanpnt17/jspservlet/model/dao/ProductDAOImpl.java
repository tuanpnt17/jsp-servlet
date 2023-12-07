/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuanpnt17.jspservlet.model.dao;

import com.tuanpnt17.jspservlet.model.dto.Category;
import com.tuanpnt17.jspservlet.model.dto.Product;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TuanPNTSE173039
 */
public class ProductDAOImpl implements ProductDAO {

  private static ProductDAO instance;
  private CategoryDAO categoryDAO = CategoryDAOImpl.getInstance();
  private Connection conn = DBContext.makeConnection();

  private ProductDAOImpl() {
  }

  public static ProductDAO getInstance() {
    if (instance == null) {
      instance = new ProductDAOImpl();
    }
    return instance;
  }

  @Override
  public List<Product> getAll() {
    List<Product> pList = new ArrayList<>();
    PreparedStatement stm;
    ResultSet rs;
    try {
      String sql = "SELECT * FROM Products";
      stm = conn.prepareStatement(sql);
      rs = stm.executeQuery();
      while (rs.next()) {
        Product p = new Product();
        p.setId(rs.getString("ID"));
        p.setName(rs.getString("name"));
        p.setQuantity(rs.getInt("quantity"));
        p.setPrice(rs.getDouble("price"));
        p.setReleaseDate(rs.getDate("releaseDate"));
        p.setDescribe(rs.getString("describe"));
        p.setImage(rs.getString("image"));
        Category c = categoryDAO.getOne(rs.getInt("cid"));
        p.setCategory(c);
        pList.add(p);
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    return pList;
  }

  @Override
  public List<Product> getProductsByCid(int cid) {
    List<Product> pList = new ArrayList<>();
    PreparedStatement stm;
    ResultSet rs;
    try {
      String sql = "SELECT * FROM Products WHERE cid = ?";
      stm = conn.prepareStatement(sql);
      stm.setInt(1, cid);
      rs = stm.executeQuery();
      while (rs.next()) {
        Product p = new Product();
        p.setId(rs.getString("ID"));
        p.setName(rs.getString("name"));
        p.setQuantity(rs.getInt("quantity"));
        p.setPrice(rs.getDouble("price"));
        p.setReleaseDate(rs.getDate("releaseDate"));
        p.setDescribe(rs.getString("describe"));
        p.setImage(rs.getString("image"));
        Category c = categoryDAO.getOne(rs.getInt("cid"));
        p.setCategory(c);
        pList.add(p);
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    return pList;
  }

  @Override
  public List<Product> search(Integer cid, String key, Double fromPrice, Double toPrice, Date fromDate, Date toDate) {
    List<Product> pList = new ArrayList<>();
    PreparedStatement stm;
    ResultSet rs;
    try {
      String sql = "SELECT * FROM Products WHERE 1=1 ";

      if (cid != null) {
        sql += " AND cid=" + cid;
      }
      if (key != null) {
        sql += " AND name like '%" + key + "%'";
      }
      if (fromPrice != null) {
        sql += " AND price>=" + fromPrice;
      }
      if (toPrice != null) {
        sql += " AND price<=" + toPrice;
      }
      if (fromDate != null) {
        sql += " AND releaseDate >= '" + fromDate + "'";
      }
      if (toDate != null) {
        sql += " AND releaseDate <= '" + toDate + "'";
      }
      stm = conn.prepareStatement(sql);
      rs = stm.executeQuery();
      while (rs.next()) {
        Product p = new Product();
        p.setId(rs.getString("ID"));
        p.setName(rs.getString("name"));
        p.setQuantity(rs.getInt("quantity"));
        p.setPrice(rs.getDouble("price"));
        p.setReleaseDate(rs.getDate("releaseDate"));
        p.setDescribe(rs.getString("describe"));
        p.setImage(rs.getString("image"));
        Category c = categoryDAO.getOne(rs.getInt("cid"));
        p.setCategory(c);
        pList.add(p);
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    return pList;
  }

}
