/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuanpnt17.jspservlet.model;

import java.io.Serializable;
import lombok.*;

/**
 *
 * @author TuanPNTSE173039
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MathHelper implements Serializable {

  private String num1 = "";
  private String num2 = "";
  private String op = "";

  public String getResult() {
    try {
      double num1 = Double.parseDouble(getNum1());
      double num2 = Double.parseDouble(getNum2());
      switch (op) {
        case "add":
          return num1 + " + " + num2 + " = " + (num1 + num2);
        case "sub":
          return num1 + " - " + num2 + " = " + (num1 - num2);
        case "mul":
          return num1 + " * " + num2 + " = " + (num1 * num2);
        case "div":
          if (num2 == 0) {
            return "Divide by 0 exception!!!";
          }
          return num1 + " / " + num2 + " = " + (num1 / num2);
      }
    } catch (NumberFormatException e) {
      System.out.println(e);
    }
    return "";
  }
}
