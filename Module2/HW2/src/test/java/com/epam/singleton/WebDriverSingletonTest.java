package com.epam.singleton;

import com.java.singleton.WebDriverFactory;
import com.java.singleton.WebDriverSingleton;
import org.junit.Assert;
import org.junit.Test;

public class WebDriverSingletonTest {

    private static final int CONSTANT_SPEED = 300;

    @Test
    public void testWebDriverSingleton(){
        WebDriverSingleton dr1 = WebDriverFactory.increaseSpeed(CONSTANT_SPEED);

        Assert.assertEquals(dr1.getSpeed(), CONSTANT_SPEED);
    }
}
