/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuanpnt17.jspservlet.model;

import lombok.*;

/**
 *
 * @author TuanPNTSE173039
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Student {

  private String id;
  private String name;
  private int yob;
  private boolean gender;

}
