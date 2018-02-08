package com.epam.spring.dao.impl;

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

    public User getUserById(long userId) {
        User user = null;
        for (Map.Entry<String, Object> entry : repository.getRepository().entrySet()) {
            if (entry.getKey().contains(USER + Long.toString(userId))) {
                user = (User) repository.getRepository().get(USER + Long.toString(userId));
            }
        }

        return user;
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
        repository.put(USER + userEntity.getId(), userEntity);
    }

    public User updateUser(User userEntity) {
        User updatedUser = null;

        if (repository.getRepository().containsKey(USER + userEntity.getId())){
            updatedUser = (User) repository.get(USER + userEntity.getId());

            updatedUser.setName(userEntity.getName());

            updatedUser.setEmail(userEntity.getEmail());

            repository.put(USER + userEntity.getId(), userEntity);
        }
        return updatedUser;
    }

    public boolean deleteUser(long userId) {
        if (repository.getRepository().containsKey(USER + Long.toString(userId))){
            repository.delete(USER + Long.toString(userId));
            return true;
        }
        return false;
    }
}
