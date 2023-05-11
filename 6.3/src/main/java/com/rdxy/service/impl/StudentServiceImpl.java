package com.rdxy.service.impl;

import com.rdxy.dao.StudentDao;
import com.rdxy.dao.impl.StudentDaoImpl;
import com.rdxy.entity.Student;
import com.rdxy.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao StudentDao=new StudentDaoImpl();

    @Override
    public boolean insert(Student Student) {
        return StudentDao.insert(Student);
    }

    @Override
    public boolean delete(int id) {
        return StudentDao.deleteById(id);
    }

    @Override
    public boolean delete(int[] ids) {
        return StudentDao.deleteByIds(ids);
    }

    @Override
    public boolean update(Student Student) {

        return StudentDao.update(Student);
    }

    @Override
    public Student getById(Student Student) {
        return StudentDao.getById(Student);
    }

    @Override
    public List<Student> getAll(String msg) {
        return StudentDao.getAll(msg);
    }

    @Override
    public Integer saveByIds(List<Student> Students) {
        return StudentDao.saveByIds(Students);
    }

    @Override
    public int deletes() {
        return StudentDao.deletes();
    }

    @Override
    public Student find_name_id(String name) {
        return StudentDao.find_name_id(name);
    }
}
