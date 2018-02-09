package com.epam.spring.utils;

import com.epam.spring.model.Event;
import com.epam.spring.model.User;
import com.epam.spring.repository.Repository;
import com.epam.spring.service.BookingFacadeServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

import static com.epam.spring.namespace.Constants.EVENT;
import static com.epam.spring.namespace.Constants.USER;

public class CommonTest {

    public final ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/resources/spring-config.xml");
    protected final BookingFacadeServiceImpl bookingService = (BookingFacadeServiceImpl) context.getBean("bookingService");
    protected final Repository repository = (Repository) context.getBean("repository");

    protected List<Event> events = new ArrayList<>();
    protected List<User> users = new ArrayList<>();

    protected void initListOfEvents(){
        for (Map.Entry<String, Object> entry : repository.getRepository().entrySet()) {
            if (entry.getKey().startsWith(EVENT)) {
                events.add((Event) entry.getValue());
            }
        }

        Collections.sort(events, UtilsComparator.eventsComparator);
    }

    protected void initEventFacade(){
        for (Event event : events){
            bookingService.createEvent(event);
        }

        Collections.sort(events, UtilsComparator.eventsComparator);

    }

    protected void initListOfUsers(){
        for (Map.Entry<String, Object> entry : repository.getRepository().entrySet()) {
            if (entry.getKey().startsWith(USER)) {
                users.add((User) entry.getValue());
            }
        }

        Collections.sort(users, UtilsComparator.usersComparator);
    }

    protected void initUsersFacade(){
        for (User user : users){
            bookingService.createUser(user);
        }

        Collections.sort(users, UtilsComparator.usersComparator);
    }


}
