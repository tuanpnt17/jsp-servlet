/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuanpnt17.jspservlet.service;

import com.tuanpnt17.jspservlet.model.dao.ProductDAO;
import com.tuanpnt17.jspservlet.model.dao.ProductDAOImpl;
import com.tuanpnt17.jspservlet.model.dto.Product;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author TuanPNTSE173039
 */
public class ProductServiceImpl implements ProductService {

  private static ProductService instance;
  private ProductDAO productDAO = ProductDAOImpl.getInstance();

  private ProductServiceImpl() {
  }

  public static ProductService getInstance() {
    if (instance == null) {
      instance = new ProductServiceImpl();
    }
    return instance;
  }

  @Override
  public List<Product> getProductList() {
    return productDAO.getAll();
  }

  @Override
  public List<Product> getProductsByCid(int cid) {
    return productDAO.getProductsByCid(cid);
  }

  @Override
  public List<Product> search(String cidStr, String key, String fromprice, String toprice, String fromdate, String todate) {
    Integer cid = null;
    Double fromPrice = null, toPrice = null;
    Date fromDate = null, toDate = null;
    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
    List<Product> pList = null;
    try {
      cid = (cidStr == null || cidStr.equals("")) ? null : Integer.parseInt(cidStr);
      fromPrice = (fromprice == null || fromprice.equals("")) ? null : Double.parseDouble(fromprice);
      toPrice = (toprice == null || toprice.isBlank()) ? null : Double.parseDouble(toprice);
      fromDate = (fromdate == null || fromdate.isBlank()) ? null : Date.valueOf(fromdate);
      toDate = (todate == null || todate.isBlank()) ? null : Date.valueOf(todate);
      pList = productDAO.search(cid, key, fromPrice, toPrice, fromDate, toDate);
    } catch (NumberFormatException e) {
      System.out.println(e);
    }
    return pList;
  }

}
