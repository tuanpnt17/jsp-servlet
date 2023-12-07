/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tuanpnt17.jspservlet.model.dao;

import com.tuanpnt17.jspservlet.model.dto.Category;
import java.util.*;

/**
 *
 * @author TuanPNTSE173039
 */
public interface CategoryDAO {

  List<Category> getAll();

  public Category getOne(int id);

  public void persist(Category category);

  public void remove(int id);

  public void update(Category category);
}
