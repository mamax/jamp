package com.epam.spring.dao.interfaces;

import com.epam.spring.model.Event;
import com.epam.spring.model.Ticket;
import com.epam.spring.model.User;

import java.util.List;

public interface TicketDAO {

    Ticket createTicket(Ticket ticket);
    List<Ticket> getBookedTickets(User user);
    List<Ticket> getBookedTickets(Event event);
    boolean cancelTicket(long ticketId);

}
