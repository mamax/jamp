package com.epam.spring.dao.impl;

import com.epam.spring.dao.interfaces.UserDAO;
import com.epam.spring.model.User;
import com.epam.spring.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StaticUserDao implements UserDAO {

    @Autowired
    Repository repository;

    @Override
    public User getUserById(long userId) {
        User user = null;
        for (Map.Entry<Long, Object> entry : repository.getRepository().entrySet()) {
            if (entry.getKey().equals(userId)) {
                user = (User) repository.getRepository().get(userId);
            }
        }

        return user;
    }

    @Override
    public User getUserByEmail(String email) {
        for (Map.Entry<Long, Object> entry : repository.getRepository().entrySet()){
            User user = (User) entry.getValue();
            if (user.getEmail().equals(email)){
                return user;
                }
            }
        return null;
    }

    @Override
    public List<User> getUsersByName(String name) {
        List<User> listUser = new ArrayList<>();
        for (Map.Entry<Long, Object> entry : repository.getRepository().entrySet()){
            User user = (User) entry.getValue();
           if (user.getName().contains(name)){
               listUser.add(user);
           }
        }

        return listUser;
    }

    @Override
    public User createUser(User userEntity) {
        repository.put(userEntity.getId(), userEntity);
        User user = (User) repository.get(userEntity.getId());
        return user;
    }

    @Override
    public User updateUser(User userEntity) {
        User updatedUser = null;

        if (repository.getRepository().containsKey(userEntity.getId())){
            updatedUser = (User) repository.get(userEntity.getId());

            updatedUser.setName(userEntity.getEmail());

            updatedUser.setEmail(userEntity.getName());

            repository.put(userEntity.getId(), userEntity);
        }
        return updatedUser;
    }

    @Override
    public boolean deleteUser(long userId) {
        if (repository.getRepository().containsKey(userId)){
            repository.delete(userId);
            return true;
        }
        return false;
    }
}
