package com.java.singleton;

public class WebDriverSingleton {

    private int speed;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    private static WebDriverSingleton driver = new WebDriverSingleton();

    private WebDriverSingleton() {
    }

    public static WebDriverSingleton getInstance() {
        return driver;
    }

}
