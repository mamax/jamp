package com.epam.spring.model;

/**
 * Created by maksym_govorischev on 14/03/14.
 */
public interface User {
    /**
     * UserServiceImpl Id. UNIQUE.
     * @return UserServiceImpl Id.
     */
    long getId();
    void setId(long id);
    String getName();
    void setName(String name);

    /**
     * UserServiceImpl email. UNIQUE.
     * @return UserServiceImpl email.
     */
    String getEmail();
    void setEmail(String email);
}
