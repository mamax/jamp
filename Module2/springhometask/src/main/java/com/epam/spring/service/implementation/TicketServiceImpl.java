package com.epam.spring.service.implementation;

import com.epam.spring.domain.Event;
import com.epam.spring.domain.Ticket;
import com.epam.spring.domain.User;
import com.epam.spring.service.model.TicketService;

public class TicketServiceImpl implements TicketService {

    Ticket ticket;
    Event event;
    User user;
    TicketService ticketService;

    public long getId() {
        return ticket.getId();
    }

    public void setId(long id) {
        ticket.setId(id);
    }

    public long getEventId() {
        return event.getId();
    }

    public void setEventId(long eventId) {
        event.setId(eventId);
    }

    public long getUserId() {
        return user.getId();
    }

    public void setUserId(long userId) {
        user.setId(userId);
    }

    public Category getCategory() {
        return ticketService.getCategory();
    }

    public void setCategory(Category category) {
        ticketService.setCategory(category);
    }

    public int getPlace() {
        return ticket.getPlace();
    }

    public void setPlace(int place) {
        ticket.setPlace(place);
    }
}
