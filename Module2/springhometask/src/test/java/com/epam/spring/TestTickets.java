package com.epam.spring;

import com.epam.spring.domain.TicketEntity;
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
        ticketList.add(TicketEntity.createNewTicket(0, 0, 1,1, Ticket.Category.STANDARD));
        ticketList.add(TicketEntity.createNewTicket(1, 0, 0,10, Ticket.Category.PREMIUM));
        ticketList.add(TicketEntity.createNewTicket(2, 1, 1,13, Ticket.Category.BAR));
        ticketList.add(TicketEntity.createNewTicket(3, 1, 0,18, Ticket.Category.BAR));
    }

    private void bookTicketsFacade() {
        facade.bookTicket(0, 1,1, Ticket.Category.STANDARD);
        facade.bookTicket(0, 0,10, Ticket.Category.PREMIUM);
        facade.bookTicket(1, 1,13, Ticket.Category.BAR);
        facade.bookTicket(1, 0,18, Ticket.Category.BAR);
    }

    @Test
    public void testCreateTicket(){
        List<Ticket> list1 = facade.getBookedTickets(users.get(0), 10, 1);
        Assert.assertTrue(ticketList.containsAll(list1));
    }

    @Test
    public void testCancelTicket(){
        int tempSize = repository.getRepository().size();
        facade.cancelTicket(1);
        int currentRepositorySize = repository.getRepository().size();

        Assert.assertEquals(tempSize-1, currentRepositorySize);
    }

    @Test
    public void testGetBookedTicketsByEvents(){
        List<Ticket> facadeList = facade.getBookedTickets(events.get(1), 5, 1);
        Assert.assertTrue(ticketList.containsAll(facadeList));
    }
}
