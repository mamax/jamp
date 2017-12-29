package com.epam.spring.utils;

import com.epam.spring.domain.EventEntity;
import com.epam.spring.domain.UserEntity;
import com.epam.spring.model.Event;
import com.epam.spring.model.User;
import com.epam.spring.service.BookingFacadeServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class CommonTest {

    public final ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/resources/spring-config.xml");
    protected final BookingFacadeServiceImpl facade = (BookingFacadeServiceImpl) context.getBean("bookingService");

    protected ArrayList<Event> events;

    protected void initListOfEvents(){
        events = new ArrayList<>();
        events.add(EventEntity.createEvent("MaxEventTitle", Calendar.getInstance(TimeZone.getTimeZone(ZoneOffset.UTC)).getTime()));
        events.add(EventEntity.createEvent("SomeEventTitle", Calendar.getInstance().getTime()));
    }

    protected void initEventFacade(){
        for (Event event : events){
            facade.createEvent(event);
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
            facade.createUser(user);
        }
    }


}
