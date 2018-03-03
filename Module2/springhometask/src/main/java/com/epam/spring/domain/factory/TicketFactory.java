package com.epam.spring.domain.factory;

import com.epam.spring.domain.TicketEntity;
import com.epam.spring.model.Ticket;

public class TicketFactory {

    public Ticket createTicket(long userId, long eventId, int place, Ticket.Category category){
        Ticket ticket = new TicketEntity();
        ticket.setEventId(eventId);
        ticket.setUserId(userId);
        ticket.setPlace(place);
        ticket.setCategory(category);
        return ticket;
    }

    public Ticket createTicket(long ticketId, long userId, long eventId, int place, Ticket.Category category) {
        Ticket ticket = new TicketEntity();
        ticket.setId(ticketId);
        ticket.setEventId(eventId);
        ticket.setUserId(userId);
        ticket.setPlace(place);
        ticket.setCategory(category);
        return ticket;
    }
}
