package com.rdxy.service.impl;

import com.rdxy.dao.UserDao;
import com.rdxy.dao.impl.UserDaoImpl;
import com.rdxy.entity.User;
import com.rdxy.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao=new UserDaoImpl();

    @Override
    public boolean insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public boolean delete(int id) {
        return userDao.deleteById(id);
    }

    @Override
    public boolean delete(int[] ids) {
        return userDao.deleteByIds(ids);
    }

    @Override
    public boolean update(User user) {

        return userDao.update(user);
    }

    @Override
    public User getById(User user) {
        return userDao.getById(user);
    }

    @Override
    public List<User> getAll(String msg) {
        return userDao.getAll(msg);
    }

    @Override
    public Integer saveByIds(List<User> users) {
        return userDao.saveByIds(users);
    }

    @Override
    public int deletes() {
        return userDao.deletes();
    }

    @Override
    public User find_name_id(String name) {
        return userDao.find_name_id(name);
    }
}
