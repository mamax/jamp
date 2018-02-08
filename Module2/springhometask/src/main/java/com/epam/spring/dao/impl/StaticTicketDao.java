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

import static com.epam.spring.namespace.Constants.TICKET;

public class StaticTicketDao implements TicketDAO {

    @Autowired
    Repository repository;
    private int ticketId = 0;

    @Override
    public Ticket createTicket(Ticket ticket) {
        ticket.setId(ticketId++);
        repository.put(TICKET+ticket.getId(), ticket);
        Ticket tempTicket = (Ticket) repository.getRepository().get(ticket.getId());
        return tempTicket;
    }

    @Override
    public List<Ticket> getBookedTickets(User user) {
        List<Ticket> ticketList = new ArrayList<>();
        for (Map.Entry<String, Object> entry :  repository.getRepository().entrySet()){
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
        for (Map.Entry<String, Object> entry : repository.getRepository().entrySet()){
            Ticket ticket = (Ticket) entry.getValue();
            if (event.getId() == ticket.getEventId()){
                ticketList.add(ticket);
            }
        }

        return ticketList;
    }

    @Override
    public boolean cancelTicket(long ticketId) {
        if (repository.getRepository().containsKey(ticketId)) {
            repository.delete(TICKET + ticketId);
            return true;
        }
        return false;
    }
}
