package com.rdxy.service;

import com.rdxy.entity.User;

import java.util.List;

public interface UserService {

    public boolean insert(User user);
    public boolean delete(int id);
    public boolean delete(int[] ids);
    public boolean update(User user);
    public User getById(User user);
    public List<User> getAll(String msg);

    Integer saveByIds(List<User> objList);
}
