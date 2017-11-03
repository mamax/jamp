package com.epam.spring.dao.impl;

import com.epam.spring.dao.interfaces.TicketDAO;
import com.epam.spring.model.Event;
import com.epam.spring.model.Ticket;
import com.epam.spring.model.User;
import com.epam.spring.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StaticTicketDao implements TicketDAO {

    @Autowired
    Repository repository;

    @Override
    public Ticket createTicket(Ticket ticket) {
        repository.put(ticket.getId(), ticket);
        return (Ticket) repository.getRepository().get(ticket.getId());
    }

    @Override
    public List<Ticket> getBookedTickets(User user) {
        List<Ticket> ticketList = new ArrayList<>();
        for (Map.Entry<Long, Object> entry :  repository.getRepository().entrySet()){
            Ticket ticket = (Ticket) entry.getValue();
            if (user.getId() == ticket.getUserId()){
                ticketList.add(ticket);
            }
        }

        return ticketList;
    }

    @Override
    public List<Ticket> getBookedTickets(Event event) {
        List<Ticket> ticketList = new ArrayList<>();
        for (Map.Entry<Long, Object> entry : repository.getRepository().entrySet()){
            Ticket ticket= (Ticket) entry.getValue();
            if (event.getId() == ticket.getEventId()){
                ticketList.add(ticket);
            }
        }

        return ticketList;
    }

    @Override
    public boolean cancelTicket(long ticketId) {
        if (repository.getRepository().containsKey(ticketId)) {
            repository.equals(ticketId);
            return true;
        }
        return false;
    }
}
