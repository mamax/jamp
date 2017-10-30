package com.epam.spring.service.implementation;

import com.epam.spring.dao.interfaces.TicketDAO;
import com.epam.spring.domain.EventEntity;
import com.epam.spring.domain.TicketEntity;
import com.epam.spring.domain.UserEntity;
import com.epam.spring.model.Ticket;

import java.util.List;

public class TicketServiceImpl {

    TicketDAO ticketDao;

    public TicketEntity bookTicket(long userId, long eventId, int place, Ticket.Category category) {
        return null;
    }

    public List<TicketEntity> getBookedTickets(UserEntity userEntity, int pageSize, int pageNum) {
        return null;
    }

    public List<EventEntity> getBookedTickets(EventEntity userEntity, int pageSize, int pageNum) {
        return null;
    }

    public boolean cancelTicket(long ticketId) {
        return false;
    }
}
