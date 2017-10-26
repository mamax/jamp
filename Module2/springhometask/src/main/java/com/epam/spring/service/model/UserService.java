package com.epam.spring.service.model;

/**
 * Created by maksym_govorischev on 14/03/14.
 */
public interface UserService {
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
