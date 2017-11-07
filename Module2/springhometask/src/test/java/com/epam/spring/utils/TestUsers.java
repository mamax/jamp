package com.epam.spring.utils;

import com.epam.spring.domain.UserEntity;
import com.epam.spring.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestUsers extends CommonTest {

    @Before
    public void init(){
        initListOfUsers();
        initUsersFacade();
    }

    @Test
    public void testCreateUser(){
        User user1 = users.get(0);
        User user2 = facade.getUserById(0);
        Assert.assertEquals(user1, user2);
    }

    @Test
    public void testUpdateUser(){
        User user = UserEntity.createUser("updatedUser", "updatedUser@epam.com");
        user.setId(1);
        facade.updateUser(user);
        Assert.assertEquals(user.getName(), facade.getUserById(1).getName());
        Assert.assertEquals(user.getEmail(), facade.getUserById(1).getEmail());
    }

    @Test
    public void testDeleteUser(){
        facade.deleteUser(1);
        Assert.assertEquals(null, facade.getUserById(1));
    }


}
