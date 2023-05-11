package com.rdxy.dao;

import com.rdxy.entity.Student;

import java.util.List;

public interface StudentDao {

    Student getById(Student Student);

    List<Student> getAll(String msg);

    boolean deleteById(int id);

    boolean deleteByIds(int[] ids);

    boolean insert(Student Student);

    boolean update(Student Student);

    Integer saveByIds(List<Student> Students);

    int deletes();

    Student find_name_id(String name);
}
