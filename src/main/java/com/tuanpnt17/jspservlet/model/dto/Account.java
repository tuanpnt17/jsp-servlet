/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuanpnt17.jspservlet.model.dto;

import lombok.*;

/**
 *
 * @author TuanPNTSE173039
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Account {

  private String username;
  private String password;
  private int role;
}
