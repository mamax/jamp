package com.epam.spring.dao.interfaces;

import com.epam.spring.model.User;

import java.util.List;

public interface UserDAO {

    User getUserById(long userId);
    User getUserByEmail(String email);
    List<User> getUsersByName(String name);
    User createUser(User userEntity);
    User updateUser(User userEntity);
    boolean deleteUser(long userId);
}
