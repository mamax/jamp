package com.epam.staticfactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserFactory {

    private static final String NAME = "name";
    private static final String LAST_NAME = "surname";

    private static User createSimpleUser() {
        User user = new User();
        user.setFirstName(NAME);
        user.setLastName(LAST_NAME);
        user.setAge(18);
        return user;
    }

    public static User createSimpleUser(String name, String surname, int age) {
        User user = new User();
        user.setFirstName(name);
        user.setLastName(surname);
        user.setAge(age);
        return user;
    }

    public static User createUserFromLastName(String lastName) {
        User user = createSimpleUser();
        user.setLastName(lastName);
        return user;
    }

    public static User createUserFromBirthday(int year){
        User user = createSimpleUser();
        user.setAge(getCurrentYear() - year);
        return user;
    }

    public static int getCurrentYear() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        Date date = new Date();
        int currentYear = Integer.parseInt(dateFormat.format(date));
        return currentYear;
    }

}
