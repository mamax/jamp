package com.epam.spring;

import com.epam.spring.domain.UserEntity;
import com.epam.spring.model.User;
import com.epam.spring.utils.CommonTest;
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
        User user2 = bookingService.getUserById(0);
        Assert.assertEquals(user1, user2);
    }

    @Test
    public void testUpdateUser(){
        User user = UserEntity.newBuilder().
                setId(1L).
                setEmail("dSome_user_from@epam.com").
                setUserName("SomeUser").
                build();

        bookingService.updateUser(user);
        Assert.assertEquals(user.getName(), bookingService.getUserById(1).getName());
        Assert.assertEquals(user.getEmail(), bookingService.getUserById(1).getEmail());
    }

    @Test
    public void testDeleteUser(){
        bookingService.deleteUser(1);
        Assert.assertEquals(null, bookingService.getUserById(1));
    }


}
