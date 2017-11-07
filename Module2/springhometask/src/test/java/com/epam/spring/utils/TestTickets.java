package com.epam.spring.utils;

import com.epam.spring.domain.TicketEntity;
import com.epam.spring.model.Ticket;
import com.epam.spring.repository.Repository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestTickets extends CommonTest {

    List<Ticket> ticketList;
    private Repository repository = (Repository) context.getBean("repository");

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
    }

    private void bookTicketsFacade() {
        facade.bookTicket(0, 1,1, Ticket.Category.STANDARD);
        facade.bookTicket(0, 0,10, Ticket.Category.PREMIUM);
        facade.bookTicket(1, 1,18, Ticket.Category.BAR);
        facade.bookTicket(1, 0,8, Ticket.Category.BAR);
    }

    @Ignore
    @Test
    public void testCreateTicket(){
        List<Ticket> list1 = facade.getBookedTickets(users.get(0), 10, 1);
        Assert.assertTrue(ticketList.containsAll(list1));
    }


    @Test
    public void testCancelTicket(){
        long tempSize = repository.getRepository().size();
        facade.cancelTicket(1);
        repository.getRepository().size();

        Assert.assertEquals(tempSize-1, repository.getRepository().size());
    }
}
