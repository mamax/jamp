package com.epam.spring.service;

import com.epam.spring.dao.impl.StaticTicketDao;
import com.epam.spring.domain.factory.TicketFactory;
import com.epam.spring.model.Event;
import com.epam.spring.model.Ticket;
import com.epam.spring.model.User;
import com.epam.spring.utils.Utils;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TicketServiceImpl {

    public TicketServiceImpl() {
    }

    public void setTicketDao(StaticTicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    StaticTicketDao ticketDao;
    private static final Logger LOG = Logger.getLogger(TicketServiceImpl.class.getName());

    public TicketServiceImpl(StaticTicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    public Ticket bookTicket(long userId, long eventId, int place, Ticket.Category category) {
        if (!Utils.isTicketParametersIsValid(userId, eventId,place, category)){
            LOG.log(Level.WARNING, String.format("Ticket parameters are not valid"));
            throw new IllegalArgumentException();
        }

        Ticket ticket = new TicketFactory().createTicket(userId, eventId, place, category);
        LOG.log(Level.INFO, "Booked ticket:" + ticket);
        return ticketDao.createTicket(ticket);
    }

    public List<Ticket> getBookedTickets(User userEntity, int pageSize, int pageNum) {
        if (!Utils.isTicketIsValid(userEntity, pageSize, pageNum)){
            LOG.log(Level.WARNING, String.format("ticket parameters are not valid"));
            throw new IllegalArgumentException();
        }
        LOG.log(Level.INFO, "Get booked tickets:" + userEntity);
        return Utils.getItemsFromPages(ticketDao.getBookedTickets(userEntity), pageSize, pageNum);
    }

    public List<Ticket> getBookedTickets(Event eventEntity, int pageSize, int pageNum) {
        if (!Utils.isTicketIsValid(eventEntity, pageSize, pageNum)){
            LOG.log(Level.WARNING, String.format("ticket parameters are not valid"));
            throw new IllegalArgumentException();
        }
        LOG.log(Level.INFO, "Get booked tickets:" + eventEntity);
        return Utils.getItemsFromPages(ticketDao.getBookedTickets(eventEntity), pageSize, pageNum);
    }

    public boolean cancelTicket(long ticketId) {
        if (!Utils.isTicketIdIsValid(ticketId)){
            LOG.log(Level.WARNING, String.format("ticket parameters are not valid"));
            throw new IllegalArgumentException();
        }
        LOG.log(Level.INFO, "Canceled ticket:" + ticketId);
        return ticketDao.cancelTicket(ticketId);
    }
}
