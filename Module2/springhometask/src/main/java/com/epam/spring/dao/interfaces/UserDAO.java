package com.epam.spring.dao.interfaces;

import com.epam.spring.domain.UserEntity;

import java.util.List;

public interface UserDAO {

    UserEntity getUserById(long userId);
    UserEntity getUserByEmail(String email);
    List<UserEntity> getUsersByName(String name);
    UserEntity createUser(UserEntity userEntity);
    UserEntity updateUser(UserEntity userEntity);
    boolean deleteUser(long userId);
}
