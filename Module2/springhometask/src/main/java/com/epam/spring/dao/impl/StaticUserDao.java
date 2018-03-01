package com.epam.spring.dao.impl;

import com.epam.spring.domain.UserEntity;
import com.epam.spring.model.User;
import com.epam.spring.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.epam.spring.namespace.Constants.USER;


public class StaticUserDao  {

    @Autowired
    Repository repository;

    private String generatedUserId(long userId) {
        return USER + Long.toString(userId);
    }

    public User getUserById(long userId) {
        return (UserEntity) repository.getById(generatedUserId(userId));
    }

    public User getUserByEmail(String email) {
        for (Map.Entry<String, Object> entry : repository.getRepository().entrySet()){
            User user = (User) entry.getValue();
            if (user.getEmail().equals(email)){
                return user;
                }
            }
        return null;
    }

    public List<User> getUsersByName(String name) {
        List<User> listUser = new ArrayList<>();
        for (Map.Entry<String, Object> entry : repository.getRepository().entrySet()){
            User user = (User) entry.getValue();
           if (user.getName().contains(name)){
               listUser.add(user);
           }
        }

        return listUser;
    }

    public void createUser(User userEntity) {
        repository.put(generatedUserId(userEntity.getId()), userEntity);
    }

    public User updateUser(User userEntity) {
        User updatedUser = null;

        if (repository.getRepository().containsKey(generatedUserId(userEntity.getId()))){
            updatedUser = (User) repository.get(generatedUserId(userEntity.getId()));

            updatedUser.setName(userEntity.getName());

            updatedUser.setEmail(userEntity.getEmail());

            repository.put(generatedUserId(userEntity.getId()), userEntity);
        }
        return updatedUser;
    }

    public boolean deleteUser(long userId) {
        return repository.delete(generatedUserId(userId));
    }
}
