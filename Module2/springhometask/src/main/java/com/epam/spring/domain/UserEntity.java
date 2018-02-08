package com.epam.spring.domain;

import com.epam.spring.model.User;

public class UserEntity implements User {

    private Long id;
    private String name;
    private String email;

    public UserEntity() {
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id =id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static User createUser(String name, String email) {
        User user = new UserEntity();
        user.setEmail(email);
        user.setName(name);
        return user;
    }

    public static User createUser(long id, String name, String email) {
        User user = new UserEntity();
        user.setId(id);
        user.setEmail(email);
        user.setName(name);
        return user;
    }
}
