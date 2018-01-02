package com.epam.singleton;

public class WebDriverSingleton {

    private Integer speed;

    /**
     * Gets speed
     * @return speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Sets speed
     * @param speed
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * Declares driver as a singleton instance
     */
    private static WebDriverSingleton driver = new WebDriverSingleton();

    /**
     * Creates private constructor
     */
    private WebDriverSingleton() {
    }

    /**
     * Gets instance of driver
     * @return
     *        Instance of driver
     */
    public static WebDriverSingleton getInstance() {
        return driver;
    }

}
