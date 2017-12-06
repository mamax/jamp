package com.epam.spring;

import com.epam.spring.domain.TicketEntity;
import com.epam.spring.facade.BookingFacade;
import com.epam.spring.model.Ticket;
import com.epam.spring.utils.CommonTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestTickets extends CommonTest {

    List<Ticket> ticketList;

    @Autowired
    protected BookingFacade ticketFacade;


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
        ticketList = new ArrayList<>();
        ticketList.add(TicketEntity.createNewTicket(0, 0, 1,1, Ticket.Category.STANDARD));
        ticketList.add(TicketEntity.createNewTicket(1, 0, 0,10, Ticket.Category.PREMIUM));
        ticketList.add(TicketEntity.createNewTicket(2, 1, 1,13, Ticket.Category.BAR));
        ticketList.add(TicketEntity.createNewTicket(3, 1, 1,18, Ticket.Category.BAR));
    }

    private void bookTicketsFacade() {
        ticketFacade.bookTicket(0, 1,1, Ticket.Category.STANDARD);
        ticketFacade.bookTicket(0, 0,10, Ticket.Category.PREMIUM);
        ticketFacade.bookTicket(1, 1,13, Ticket.Category.BAR);
        ticketFacade.bookTicket(1, 0,8, Ticket.Category.BAR);
    }

    @Test
    public void testCreateTicket(){
        List<Ticket> list1 = ticketFacade.getBookedTickets(users.get(0), 10, 1);
        Assert.assertTrue(ticketList.containsAll(list1));
    }

    @Test
    public void testGetBookedTicketsByEvents(){
        List<Ticket> facadeList = ticketFacade.getBookedTickets(events.get(0), 5, 1);
        Assert.assertTrue(ticketList.contains(facadeList));
    }

    @Test
    public void testCancelTicket(){
        long tempSize = repository.getRepository().size();
        ticketFacade.cancelTicket(1);
        repository.getRepository().size();

        Assert.assertEquals(tempSize-1, repository.getRepository().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteTicketWithWrongId() {
        bookingFacade.deleteUser(-50);
    }

    @After
    public void tearDown(){
        repository.getRepository().clear();
    }

}
