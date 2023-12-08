/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuanpnt17.jspservlet.service;

import com.tuanpnt17.jspservlet.model.dao.AuthenDAO;
import com.tuanpnt17.jspservlet.model.dao.AuthenDAOImpl;
import com.tuanpnt17.jspservlet.model.dto.Account;

/**
 *
 * @author TuanPNTSE173039
 */
public class AuthenServiceImpl implements AuthenService {

  private static AuthenService instance;
  private AuthenDAO authenDAO = AuthenDAOImpl.getInstance();

  private AuthenServiceImpl() {
  }

  public static AuthenService getInstance() {
    if (instance == null) {
      instance = new AuthenServiceImpl();
    }
    return instance;
  }

  @Override
  public Account login(String username, String password) {
    return authenDAO.login(username, password);
  }

  @Override
  public Account addNewAccount(String username, String password) {
    authenDAO.persist(username, password);
    return new Account(username, password, 2);
  }

  @Override
  public Account getAccount(String username) {
    return authenDAO.getAccount(username);
  }

}
