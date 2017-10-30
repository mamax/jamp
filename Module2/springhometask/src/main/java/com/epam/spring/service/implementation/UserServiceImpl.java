package com.epam.spring.service.implementation;

import com.epam.spring.dao.interfaces.UserDAO;
import com.epam.spring.domain.UserEntity;

import java.util.List;

public class UserServiceImpl{

    UserDAO userDAO;

    public UserEntity getUserById(long userId) {
        return null;
    }

    public UserEntity getUserByEmail(String email) {
        return null;
    }

    public List<UserEntity> getUsersByName(String name, int pageSize, int pageNum) {
        return null;
    }

    public UserEntity createUser(UserEntity userEntity) {
        return null;
    }

    public UserEntity updateUser(UserEntity userEntity) {
        return null;
    }

    public boolean deleteUser(long userId) {
        return false;
    }
}
