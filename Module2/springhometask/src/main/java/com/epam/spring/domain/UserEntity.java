package com.epam.spring.domain;

import com.epam.spring.model.User;

public class UserEntity implements User {

    private String name;
    private String email;
    private Long userId;

    @Override
    public long getId() {
        return userId;
    }

    @Override
    public void setId(long id) {
        this.userId=id;
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

}
