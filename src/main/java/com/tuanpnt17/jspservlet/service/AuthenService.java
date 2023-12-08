/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tuanpnt17.jspservlet.service;

import com.tuanpnt17.jspservlet.model.dto.Account;

/**
 *
 * @author TuanPNTSE173039
 */
public interface AuthenService {

  public Account login(String username, String password);

  public Account addNewAccount(String username, String password);

  public Account getAccount(String username);

}
