package com.epam.spring.service.implementation;

import com.epam.spring.domain.Event;
import com.epam.spring.domain.Ticket;
import com.epam.spring.domain.User;
import com.epam.spring.facade.BookingFacade;

import java.util.Date;
import java.util.List;

public class BookingFacadeServiceImpl implements BookingFacade {

    public Event getEventById() {
        return null;
    }

    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return null;
    }

    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return null;
    }

    public Event createEvent(Event event) {
        return null;
    }

    public Event updateEvent(Event event) {
        return null;
    }

    public boolean deleteEvent(long eventId) {
        return false;
    }

    public User getUserById(long userId) {
        return null;
    }

    public User getUserByEmail(String email) {
        return null;
    }

    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return null;
    }

    public User createUser(User user) {
        return null;
    }

    public User updateUser(User user) {
        return null;
    }

    public boolean deleteUser(long userId) {
        return false;
    }

    public Ticket bookTicket(long userId, long eventId, int place, Ticket.Category category) {
        return null;
    }

    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return null;
    }

    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return null;
    }

    public boolean cancelTicket(long ticketId) {
        return false;
    }
}
