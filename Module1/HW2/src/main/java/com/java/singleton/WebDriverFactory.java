package com.java.singleton;

import static com.java.singleton.WebDriverSingleton.getInstance;

public class WebDriverFactory {

    /**
     * Increases current speed
     * @param speed
     * @return
     *        Instance od driver
     */
    public static WebDriverSingleton increaseSpeed(int speed){
        WebDriverSingleton dr1 = getInstance();
        int currentSpeed = dr1.getSpeed() + speed;
        dr1.setSpeed(currentSpeed);
        return dr1;
    }
}
