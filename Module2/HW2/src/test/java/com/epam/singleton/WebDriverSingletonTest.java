package com.epam.singleton;

import com.java.singleton.WebDriver;
import com.java.singleton.WebDriverSingleton;
import org.junit.Assert;
import org.junit.Test;

public class WebDriverSingletonTest {

    private static final int CONSTANT_SPEED = 300;

    @Test
    public void testWebDriverSingleton(){
        WebDriver dr1 = WebDriverSingleton.increaseDriver(CONSTANT_SPEED);

        Assert.assertEquals(dr1.getSpeed(), CONSTANT_SPEED);
    }
}
