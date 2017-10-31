package com.epam.spring.service;

import com.epam.spring.dao.interfaces.TicketDAO;
import com.epam.spring.domain.TicketEntity;
import com.epam.spring.model.Event;
import com.epam.spring.model.Ticket;
import com.epam.spring.model.User;
import com.epam.spring.utils.Utils;

import java.util.List;

public class TicketServiceImpl {

    TicketDAO ticketDao;

    public Ticket bookTicket(long userId, long eventId, int place, Ticket.Category category) {

        Ticket ticket = new TicketEntity.Builder().
                setUserId(userId).
                setEventId(eventId).
                setPlace(place).
                setCategory(category).build();

        return ticketDao.createTicket(ticket);
    }

    public List<Ticket> getBookedTickets(User userEntity, int pageSize, int pageNum) {
        return Utils.getItemsFromPages(ticketDao.getBookedTickets(userEntity), pageSize, pageNum);
    }

    public List<Ticket> getBookedTickets(Event eventEntity, int pageSize, int pageNum) {
        return Utils.getItemsFromPages(ticketDao.getBookedTickets(eventEntity), pageSize, pageNum);
    }

    public boolean cancelTicket(long ticketId) {
        return ticketDao.cancelTicket(ticketId);
    }
}
