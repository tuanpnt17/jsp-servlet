/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuanpnt17.jspservlet.model.dto;

import java.sql.Date;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {

  private String id;
  private String name;
  private int quantity;
  private double price;
  private Date releaseDate;
  private String describe;
  private String image;
  private Category category;
}
