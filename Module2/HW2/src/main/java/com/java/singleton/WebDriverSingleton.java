package com.java.singleton;

public class WebDriverSingleton {

    private static WebDriver driver;

    private WebDriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (driver == null){
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static WebDriver increaseDriver(int speed){
        WebDriver dr1 = getDriver();
        int currentSpeed = dr1.getSpeed()+speed;
        dr1.setSpeed(currentSpeed);
        return dr1;
    }


}
