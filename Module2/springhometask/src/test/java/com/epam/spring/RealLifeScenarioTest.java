package com.epam.spring;

import com.epam.spring.domain.EventEntity;
import com.epam.spring.domain.UserEntity;
import com.epam.spring.model.Event;
import com.epam.spring.model.Ticket;
import com.epam.spring.model.User;
import com.epam.spring.utils.CommonTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

public class RealLifeScenarioTest extends CommonTest {

    private ArrayList<Event> eventList = new ArrayList<>();
    private ArrayList<User> userList = new ArrayList<>();

    @Test
    public void testSomeRealScenario(){

        User testUser = UserEntity.newBuilder().setUserName("updatedUser").setEmail("updatedUser@epam.com").build();
        userList.add(testUser);

        User testUser1 = UserEntity.newBuilder().setUserName("maksym_mazurkevych").setEmail("Maksym_Mazurkevych@epam.com").build();
        userList.add(testUser1);

        for (User eve : userList) {
            bookingService.createUser(eve);
        }

        Event event = EventEntity.newBuilder().setTitle("RealEventScenario").setDate(new Date()).build();
        eventList.add(event);

        Event event1 = EventEntity.newBuilder().setTitle("Vakarchuk").setDate(new Date()).build();
        eventList.add(event1);

        for (Event eve : eventList) {
            bookingService.createEvent(eve);
        }

        bookingService.bookTicket(testUser.getId(), event.getId(), 10, Ticket.Category.BAR);
        bookingService.bookTicket(testUser1.getId(), event.getId(), 11, Ticket.Category.BAR);

        bookingService.bookTicket(testUser.getId(), event1.getId(), 111, Ticket.Category.PREMIUM);
        bookingService.bookTicket(testUser1.getId(), event1.getId(), 112, Ticket.Category.PREMIUM);

        Assert.assertEquals(bookingService.getBookedTickets(testUser, 5, 1).size(), 4);
        Assert.assertEquals(bookingService.getBookedTickets(testUser1, 5, 1).size(), 4);

        bookingService.cancelTicket(3);

        Assert.assertEquals(bookingService.getBookedTickets(testUser1, 5, 1).size(), 3);
    }
}
