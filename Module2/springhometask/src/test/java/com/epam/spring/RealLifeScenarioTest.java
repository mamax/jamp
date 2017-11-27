package com.epam.spring;

import com.epam.spring.domain.EventEntity;
import com.epam.spring.domain.UserEntity;
import com.epam.spring.model.Event;
import com.epam.spring.model.Ticket;
import com.epam.spring.model.User;
import com.epam.spring.utils.CommonTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
public class RealLifeScenarioTest extends CommonTest {

    private ArrayList<Event> eventList = new ArrayList<>();

    @Test
    public void testSomeRealScenario(){

        User testUser = UserEntity.createUser("updatedUser", "updatedUser@epam.com");
        bookingFacade.createUser(testUser);

        User testUser1 = UserEntity.createUser("maksym_mazurkevych", "Maksym_Mazurkevych@epam.com");
        bookingFacade.createUser(testUser1);

        Event event = EventEntity.createEvent("RealEventScenario", new Date());
        eventList.add(event);

        Event event1 = EventEntity.createEvent("Vakarchuk", new Date());
        eventList.add(event1);

        for (Event eve : eventList) {
            bookingFacade.createEvent(eve);
        }

        bookingFacade.bookTicket(testUser.getId(), event.getId(), 10, Ticket.Category.BAR);
        bookingFacade.bookTicket(testUser1.getId(), event.getId(), 11, Ticket.Category.BAR);

        bookingFacade.bookTicket(testUser.getId(), event1.getId(), 111, Ticket.Category.PREMIUM);
        bookingFacade.bookTicket(testUser1.getId(), event1.getId(), 112, Ticket.Category.PREMIUM);

        Assert.assertEquals(bookingFacade.getBookedTickets(testUser, 5, 1).size(), 2);
        Assert.assertEquals(bookingFacade.getBookedTickets(testUser1, 5, 1).size(), 2);

        bookingFacade.cancelTicket(3);

        Assert.assertEquals(bookingFacade.getBookedTickets(testUser1, 5, 1).size(), 1);

    }


}
