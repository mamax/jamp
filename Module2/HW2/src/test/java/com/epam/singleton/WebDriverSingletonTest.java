package com.epam.singleton;

import com.java.singleton.WebDriver;
import com.java.singleton.WebDriverSingleton;
import org.junit.Assert;
import org.junit.Test;

public class WebDriverSingletonTest {

    private static final int increasSpeed = 300;

    @Test
    public void testWebDriverSingleton(){
        WebDriver dr1 = WebDriverSingleton.increaseDriver(increasSpeed);

        Assert.assertEquals(dr1.getSpeed(), increasSpeed);
    }
}
