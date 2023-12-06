/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuanpnt17.jspservlet.service;

import com.tuanpnt17.jspservlet.model.Student;

import java.util.*;

/**
 *
 * @author TuanPNTSE173039
 */
public class StudentList extends ArrayList<Student> {

  private Random r = new Random();

  public StudentList() {
//    this.add(new Student("SE173039", "Tuan Pham", 2003, true));
//    this.add(new Student("SE173038", "An Nguyen", 2003, true));
//    this.add(new Student("SE180432", "Nguyen Tran", 2002, false));
//    this.add(new Student("SE180123", "My Tran", 2005, false));
  }

  public List<Student> getAll() {
    return this;
  }

  public List<Student> createStudent(int num) {
    String[] names = {"Tuan Pham", "An Nguyen", "Nguyen Tran", "Hang Phan"};
    for (int i = 0; i < num; i++) {
      String id = "SE" + i;
      String name = names[r.nextInt(names.length)];
      int yob = 2003;
      boolean gender = r.nextBoolean();
      this.add(new Student(id, name, yob, gender));
    }
    return this;
  }
}
