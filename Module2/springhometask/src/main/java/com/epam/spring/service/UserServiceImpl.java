package com.epam.spring.service;

import com.epam.spring.dao.impl.StaticUserDao;
import com.epam.spring.model.User;
import com.epam.spring.utils.Utils;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserServiceImpl{

    public void setUserDAO(StaticUserDao userDAO) {
        this.userDAO = userDAO;
    }

    StaticUserDao userDAO;
    private long userId = 0;
    private static final Logger LOG = Logger.getLogger(UserServiceImpl.class.getName());

    public UserServiceImpl(StaticUserDao userDAO) {
        this.userDAO = userDAO;
    }

    public User getUserById(long userId) {
        if (!Utils.isUserIdIsValid(userId)){
            LOG.log(Level.WARNING, String.format("userId is not valid"));
            throw new IllegalArgumentException();
        }
        LOG.log(Level.INFO, "Get user by id :"+ userId);
        return userDAO.getUserById(userId);
    }

    public User getUserByEmail(String email) {
        if (!Utils.isEmailIsValid(email)){
            LOG.log(Level.WARNING, String.format("email is not valid"));
            throw new IllegalArgumentException();
        }
        LOG.log(Level.INFO, "Get user by email" + email);
        return userDAO.getUserByEmail(email);
    }

    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        if (!Utils.isUsersParametersIsValid(name, pageSize, pageNum)){
            LOG.log(Level.WARNING, String.format("Users parameters is not valid"));
            throw new IllegalArgumentException();
        }
        List<User> userList = Utils.getItemsFromPages(userDAO.getUsersByName(name), pageSize, pageNum);
        LOG.log(Level.INFO, "Get users by name" + name);
        return userList;
    }

    public User createUser(User userEntity) {
        if(!Utils.isUserValid(userEntity)){
            LOG.log(Level.WARNING, String.format("userEntity is not valid"));
            throw new IllegalArgumentException();
        }
        userEntity.setId(userId++);
        userDAO.createUser(userEntity);
        LOG.log(Level.INFO, "Created user" + userEntity);
        return userEntity;
    }

    public User updateUser(User userEntity) {
        if(!Utils.isUserValid(userEntity)){
            LOG.log(Level.WARNING, String.format("userEntity is not valid"));
            throw new IllegalArgumentException();
        }
        LOG.log(Level.INFO, "Updated user:" + userEntity);
        return userDAO.updateUser(userEntity);
    }

    public boolean deleteUser(long userId) {
        if (!Utils.isUserIdIsValid(userId)){
            LOG.log(Level.WARNING, String.format("userEntity is not valid"));
            throw new IllegalArgumentException();
        }
        LOG.log(Level.INFO, "Deleted user:" + userId);
        return userDAO.deleteUser(userId);
    }
}
