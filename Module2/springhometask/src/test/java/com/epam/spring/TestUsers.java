package com.epam.spring;

import com.epam.spring.domain.UserEntity;
import com.epam.spring.model.User;
import com.epam.spring.utils.CommonTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestUsers extends CommonTest {

    @Before
    public void init(){
        initListOfUsers();
        initUsersFacade();
    }

    @Test
    public void testCreateUser(){
        Assert.assertEquals(users.size(), 2);
    }

    @Test
    public void testUpdateUser(){
        User user = UserEntity.createUser("updatedUser", "updatedUser@epam.com");
        user.setId(1);
        bookingFacade.updateUser(user);
        Assert.assertEquals(user.getName(), bookingFacade.getUserById(1).getName());
        Assert.assertEquals(user.getEmail(), bookingFacade.getUserById(1).getEmail());
    }

    @Test
    public void testDeleteUser(){
        bookingFacade.deleteUser(1);
        Assert.assertEquals(null, bookingFacade.getUserById(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeletingUserWithWrongId() {
        bookingFacade.deleteUser(-50);
    }

    @After
    public void tearDown(){
        repository.getRepository().remove(0);
        repository.getRepository().remove(1);
    }

}
