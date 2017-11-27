package com.epam.spring.utils;

import com.epam.spring.domain.EventEntity;
import com.epam.spring.domain.UserEntity;
import com.epam.spring.facade.BookingFacade;
import com.epam.spring.model.Event;
import com.epam.spring.model.User;
import com.epam.spring.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;


@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class CommonTest {

    @Autowired
    protected Repository repository;

    @Autowired
    protected BookingFacade bookingFacade;

    protected ArrayList<Event> events;

    protected void initListOfEvents(){
        events = new ArrayList<>();
        events.add(EventEntity.createEvent("MaxEventTitle", Calendar.getInstance(TimeZone.getTimeZone(ZoneOffset.UTC)).getTime()));
        events.add(EventEntity.createEvent("SomeEventTitle", Calendar.getInstance().getTime()));
    }

    protected void initEventFacade(){
        for (Event event : events){
            bookingFacade.createEvent(event);
        }
    }

    protected List<User> users;

    protected void initListOfUsers(){
        users = new ArrayList<>();
        users.add(UserEntity.createUser("Max", "maksym.Mazurkevych@gmail.com"));
        users.add(UserEntity.createUser("SomeUser", "SomeUser@gmail.com"));
    }

    protected void initUsersFacade(){
        for (User user : users){
            bookingFacade.createUser(user);
        }
    }



}
