package com.rdxy.service.impl;

import com.rdxy.dao.StudentDao;
import com.rdxy.dao.impl.StudentDaoImpl;
import com.rdxy.entity.Student;
import com.rdxy.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao dao=new StudentDaoImpl();

    @Override
    public boolean insert(Student Student) {
        return dao.insert(Student);
    }

    @Override
    public boolean delete(int id) {
        return dao.delete(id);
    }

    @Override
    public boolean update(Student Student) {

        return dao.update(Student);
    }

    @Override
    public Student getOne(String id) {
        return dao.getOne(id);
    }


    @Override
    public List<Student> getAll(String msg) {
        return dao.getAll(msg);
    }

    @Override
    public Integer saveByIds(List<Student> Students) {
        return dao.saveByIds(Students);
    }


}
