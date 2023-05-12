package com.rdxy.service;

import com.rdxy.entity.Student;

import java.util.List;

public interface StudentService {

    boolean insert(Student Student);
    boolean delete(int id);
    int delete();
    boolean update(Student Student);
    Student getOne(String id);
    List<Student> getAll(String msg);

    Integer saveByIds(List<Student> list);


}
