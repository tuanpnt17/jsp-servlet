/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tuanpnt17.jspservlet.service;

import com.tuanpnt17.jspservlet.model.dto.Product;
import java.util.List;

/**
 *
 * @author TuanPNTSE173039
 */
public interface ProductService {

  public List<Product> getProductList();

  public List<Product> getProductsByCid(int cid);

  public List<Product> search(String cidStr, String key, String fromprice, String toprice, String fromdate, String todate);

}
