package com.epam.spring.domain.factory;

import com.epam.spring.domain.UserEntity;
import com.epam.spring.model.User;

public class UserFactory{

    public User createUser(String name, String email){
        User user = new UserEntity();
        user.setName(name);
        user.setEmail(email);
        return user;
    }

    public User createUser(long id, String name, String email){
        User user = new UserEntity();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        return user;
    }


}
