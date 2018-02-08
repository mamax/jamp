package com.epam.spring.utils;

import com.epam.spring.model.Event;
import com.epam.spring.model.User;

import java.util.Comparator;

public class UtilsComparator {

    public static Comparator eventsComparator = new Comparator<Event>() {
        @Override
        public int compare(Event object1, Event object2) {
            return object1.getId() > object2.getId() ? 1 : -1;
        }
    };

    public static Comparator usersComparator = new Comparator<User>() {
        @Override
        public int compare(User object1, User object2) {
            return object1.getId() > object2.getId() ? 1 : -1;
        }
    };

}
