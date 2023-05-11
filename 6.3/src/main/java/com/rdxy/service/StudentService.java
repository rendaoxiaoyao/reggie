package com.rdxy.service;

import com.rdxy.entity.Student;

import java.util.List;

public interface StudentService {

    public boolean insert(Student Student);
    public boolean delete(int id);
    public boolean delete(int[] ids);
    public boolean update(Student Student);
    public Student getById(Student Student);
    public List<Student> getAll(String msg);

    Integer saveByIds(List<Student> objList);

    int deletes();

    Student find_name_id(String name);
}
