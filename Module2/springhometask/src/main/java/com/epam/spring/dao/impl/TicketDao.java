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

public class TicketDao implements TicketDAO {

    @Autowired
    private Repository repository;
    private int ticketId = 0;

    private String generatedTicketId(long ticketId) {
        return TICKET + Long.toString(ticketId);
    }

    @Override
    public Ticket createTicket(Ticket ticket) {
        ticket.setId(ticketId++);
        repository.put(generatedTicketId(ticket.getId()), ticket);
        Ticket tempTicket = (Ticket) repository.getById(generatedTicketId(ticket.getId()));
        return tempTicket;
    }

    @Override
    public List<Ticket> getBookedTickets(User user) {
        List<Ticket> ticketList = new ArrayList<>();
        for (Map.Entry<String, Object> entry :  repository.getRepository().entrySet()){
            if (entry.getKey().startsWith(TICKET)) {
                Ticket ticket = (Ticket) entry.getValue();
                if (user.getId() == ticket.getUserId()) {
                    ticketList.add(ticket);
                }
            }
        }

        return ticketList;
    }

    @Override
    public List<Ticket> getBookedTickets(Event event) {
        List<Ticket> ticketList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : repository.getRepository().entrySet()){
            if (entry.getKey().startsWith(TICKET)) {
                Ticket ticket = (Ticket) entry.getValue();
                if (event.getId() == ticket.getEventId()) {
                    ticketList.add(ticket);
                }
            }
        }

        return ticketList;
    }

    @Override
    public boolean cancelTicket(long ticketId) {
        return repository.delete(generatedTicketId(ticketId));
    }
}
