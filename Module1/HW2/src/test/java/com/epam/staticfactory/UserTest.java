package com.epam.staticfactory;

import org.junit.Assert;
import org.junit.Test;

import static com.epam.staticfactory.UserFactory.getCurrentYear;

public class UserTest {

    private static final String NAME = "Maksym";
    private static final String SURNAME = "Mazurkevych";

    @Test
    public void testUser(){
        User testUser = UserFactory.createSimpleUser(NAME, SURNAME, 1990);
        testUser.setAge(getCurrentYear()-testUser.getAge());

        Assert.assertEquals(NAME, testUser.getFirstName());
        Assert.assertEquals(27, testUser.getAge());
    }
}
