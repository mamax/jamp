package com.epam.spring.service.implementation;

import com.epam.spring.domain.User;
import com.epam.spring.service.model.UserService;

public class UserServiceImpl implements UserService {

    private User user;

    public long getId() {
        return user.getId();
    }

    public void setId(long id) {
        user.setId(id);
    }

    public String getName() {
        return user.getName();
    }

    public void setName(String name) {
        user.setName(name);
    }

    public String getEmail() {
        return user.getEmail();
    }

    public void setEmail(String email) {
            user.setEmail(email);
    }
}
