/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuanpnt17.jspservlet.service;

import com.tuanpnt17.jspservlet.model.dao.CategoryDAO;
import com.tuanpnt17.jspservlet.model.dao.CategoryDAOImpl;
import com.tuanpnt17.jspservlet.model.dto.Category;
import java.util.List;

/**
 *
 * @author TuanPNTSE173039
 */
public class CategoryServiceImpl implements CategoryService {

  private static CategoryService instance;
  private CategoryDAO categoryDAO = CategoryDAOImpl.getInstance();

  private CategoryServiceImpl() {
  }

  public static CategoryService getInstance() {
    if (instance == null) {
      instance = new CategoryServiceImpl();
    }
    return instance;
  }

  @Override
  public List<Category> getCategoryList() {
    return categoryDAO.getAll();
  }

}
