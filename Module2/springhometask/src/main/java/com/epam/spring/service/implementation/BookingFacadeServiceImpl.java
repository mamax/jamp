package com.epam.spring.service.implementation;

import com.epam.spring.domain.EventEntity;
import com.epam.spring.domain.TicketEntity;
import com.epam.spring.domain.UserEntity;
import com.epam.spring.facade.BookingFacade;
import com.epam.spring.model.Ticket;

import java.util.Date;
import java.util.List;

public class BookingFacadeServiceImpl implements BookingFacade {

    EventServiceImpl eventService;
    UserServiceImpl userService;
    TicketServiceImpl ticketService;

    @Override
    public EventEntity getEventById(long eventId) {
        return eventService.getEventById(eventId);
    }

    public List<EventEntity> getEventsByTitle(String title, int pageSize, int pageNum) {
        return eventService.getEventsByTitle(title, pageSize, pageNum);
    }

    public List<EventEntity> getEventsForDay(Date day, int pageSize, int pageNum) {
        return eventService.getEventsForDay(day, pageSize, pageNum);
    }

    public EventEntity createEvent(EventEntity eventEntity) {
        return eventService.createEvent(eventEntity);
    }

    public EventEntity updateEvent(EventEntity eventEntity) {
        return eventService.updateEvent(eventEntity);
    }

    public boolean deleteEvent(long eventId) {
        return eventService.deleteEvent(eventId);
    }

    public UserEntity getUserById(long userId) {
        return userService.getUserById(userId);
    }

    public UserEntity getUserByEmail(String email) {
        return userService.getUserByEmail(email);
    }

    public List<UserEntity> getUsersByName(String name, int pageSize, int pageNum) {
        return userService.getUsersByName(name, pageSize, pageNum);
    }

    public UserEntity createUser(UserEntity userEntity) {
        return userService.createUser(userEntity);
    }

    public UserEntity updateUser(UserEntity userEntity) {
        return userService.updateUser(userEntity);
    }

    public boolean deleteUser(long userId) {
        return userService.deleteUser(userId);
    }

    public TicketEntity bookTicket(long userId, long eventId, int place, Ticket.Category category) {
        return ticketService.bookTicket(userId, eventId, place, category);
    }

    public List<TicketEntity> getBookedTickets(UserEntity userEntity, int pageSize, int pageNum) {
        return ticketService.getBookedTickets(userEntity, pageSize, pageNum);
    }

    public List<EventEntity> getBookedTickets(EventEntity eventEntity, int pageSize, int pageNum) {
        return ticketService.getBookedTickets(eventEntity, pageSize, pageNum);
    }

    public boolean cancelTicket(long ticketId) {
        return ticketService.cancelTicket(ticketId);
    }
}
