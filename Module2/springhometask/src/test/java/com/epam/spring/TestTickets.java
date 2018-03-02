package com.epam.spring;

import com.epam.spring.domain.factory.TicketFactory;
import com.epam.spring.model.Ticket;
import com.epam.spring.utils.CommonTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestTickets extends CommonTest {

    List<Ticket> ticketList = new ArrayList<>();

    @Before
    public void init(){
        initListOfEvents();
        initEventFacade();
        initListOfUsers();
        initUsersFacade();
        initListOfTickets();
        bookTicketsFacade();
    }

    private void initListOfTickets() {
        ticketList.add(TicketFactory.createTicket(0, 0, 1,1, Ticket.Category.STANDARD));
        ticketList.add(TicketFactory.createTicket(1, 0, 0,10, Ticket.Category.PREMIUM));
        ticketList.add(TicketFactory.createTicket(2, 1, 1,13, Ticket.Category.BAR));
        ticketList.add(TicketFactory.createTicket(3, 1, 0,18, Ticket.Category.BAR));
    }

    private void bookTicketsFacade() {
        bookingService.bookTicket(0, 1,1, Ticket.Category.STANDARD);
        bookingService.bookTicket(0, 0,10, Ticket.Category.PREMIUM);
        bookingService.bookTicket(1, 1,13, Ticket.Category.BAR);
        bookingService.bookTicket(1, 0,18, Ticket.Category.BAR);
    }

    @Test
    public void testCreateTicket(){
        List<Ticket> list1 = bookingService.getBookedTickets(users.get(0), 10, 1);
        Assert.assertTrue(ticketList.containsAll(list1));
    }

    @Test
    public void testCancelTicket(){
        int tempSize = repository.getRepository().size();
        bookingService.cancelTicket(1);
        int currentRepositorySize = repository.getRepository().size();

        Assert.assertEquals(tempSize-1, currentRepositorySize);
    }

    @Test
    public void testGetBookedTicketsByEvents(){
        List<Ticket> facadeList = bookingService.getBookedTickets(events.get(1), 5, 1);
        Assert.assertTrue(ticketList.containsAll(facadeList));
    }
}
