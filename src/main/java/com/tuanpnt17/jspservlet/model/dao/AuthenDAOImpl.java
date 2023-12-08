/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuanpnt17.jspservlet.model.dao;

import com.tuanpnt17.jspservlet.model.dto.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author TuanPNTSE173039
 */
public class AuthenDAOImpl implements AuthenDAO {

  private static AuthenDAO instance;
  private Connection conn = DBContext.makeConnection();

  private AuthenDAOImpl() {
  }

  public static AuthenDAO getInstance() {
    if (instance == null) {
      instance = new AuthenDAOImpl();
    }
    return instance;
  }

  @Override
  public Account login(String username, String password) {
    PreparedStatement stm;
    ResultSet rs;
    try {
      String sql = "SELECT * FROM Admin WHERE Username = ? AND Password = ?";
      stm = conn.prepareStatement(sql);
      stm.setString(1, username);
      stm.setString(2, password);
      rs = stm.executeQuery();
      if (rs.next()) {
        return new Account(
                rs.getString("Username"),
                rs.getString("Password"),
                rs.getInt("role"));
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    return null;
  }

  @Override
  public void persist(String username, String password) {
    PreparedStatement stm;
    try {
      String sql = "INSERT INTO Admin VALUES (?,?,2)";
      stm = conn.prepareStatement(sql);
      stm.setString(1, username);
      stm.setString(2, password);
      stm.executeUpdate();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  @Override
  public Account getAccount(String username) {
    PreparedStatement stm;
    ResultSet rs;
    try {
      String sql = "SELECT * FROM Admin WHERE Username = ?";
      stm = conn.prepareStatement(sql);
      stm.setString(1, username);
      rs = stm.executeQuery();
      if (rs.next()) {
        return new Account(
                rs.getString("Username"),
                rs.getString("Password"),
                rs.getInt("role"));
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    return null;
  }

}
