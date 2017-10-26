package com.epam.spring.dao.interfaces;

import com.epam.spring.domain.UserObject;

import java.util.List;

public interface UserDAO {

    UserObject getUserById(long userId);
    UserObject getUserByEmail(String email);
    List<UserObject> getUsersByName(String name);
    UserObject createUser(UserObject userObject);
    UserObject updateUser(UserObject userObject);
    boolean deleteUser(long userId);
}
