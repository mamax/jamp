package com.epam.spring.domain;

import com.epam.spring.model.User;

public class UserEntity implements User {

    private long id;
    private String name;
    private String email;

    public UserEntity() {
    }

    public static Builder newBuilder() {
        return new UserEntity().new Builder();
    }

    public class Builder{

        private Builder(){
        }

        public Builder setId(long id) {
            UserEntity.this.id = id;
            return this;
        }

        public Builder setEmail(String email) {
            UserEntity.this.email = email;
            return this;
        }

        public Builder setUserName(String name){
            UserEntity.this.name = name;
            return this;
        }

        public UserEntity build(){
            return UserEntity.this;
        }

    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
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
