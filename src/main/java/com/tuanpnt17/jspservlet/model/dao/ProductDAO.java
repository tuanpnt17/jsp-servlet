/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tuanpnt17.jspservlet.model.dao;

import com.tuanpnt17.jspservlet.model.dto.Product;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author TuanPNTSE173039
 */
public interface ProductDAO {

  public List<Product> getAll();

  public List<Product> getProductsByCid(int cid);

  public List<Product> search(Integer cid, String key, Double fromPrice, Double toPrice, Date fromDate, Date toDate);

}
