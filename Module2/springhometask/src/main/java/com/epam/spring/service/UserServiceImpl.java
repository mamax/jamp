package com.epam.spring.service;

import com.epam.spring.dao.impl.StaticUserDao;
import com.epam.spring.model.User;
import com.epam.spring.utils.Utils;

import java.util.List;

public class UserServiceImpl{

    StaticUserDao userDAO;

    public User getUserById(long userId) {
        return userDAO.getUserById(userId);
    }

    public User getUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }

    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        List<User> userList = Utils.getItemsFromPages(userDAO.getUsersByName(name), pageSize, pageNum);
        return userList;
    }

    public User createUser(User userEntity) {
        return userDAO.createUser(userEntity);
    }

    public User updateUser(User userEntity) {
        return userDAO.updateUser(userEntity);
    }

    public boolean deleteUser(long userId) {
        return userDAO.deleteUser(userId);
    }
}
