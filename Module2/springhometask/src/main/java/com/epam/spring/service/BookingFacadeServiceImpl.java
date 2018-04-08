package com.epam.spring.service;

import com.epam.spring.domain.UserAccountEntity;
import com.epam.spring.facade.BookingFacade;
import com.epam.spring.model.Event;
import com.epam.spring.model.Ticket;
import com.epam.spring.model.User;
import com.epam.spring.model.UserAccount;

import java.util.Date;
import java.util.List;

public class BookingFacadeServiceImpl implements BookingFacade {

    private EventServiceImpl eventService;
    private UserServiceImpl userService;
    private TicketServiceImpl ticketService;
    private UserAccountServiceImpl userAccountService;

    public BookingFacadeServiceImpl(EventServiceImpl eventService, UserServiceImpl userService, TicketServiceImpl ticketService, UserAccountServiceImpl userAccountService) {
        this.eventService = eventService;
        this.userService = userService;
        this.ticketService = ticketService;
        this.userAccountService = userAccountService;
    }

    @Override
    public Event getEventById(long eventId) {
        return eventService.getEventById(eventId);
    }

    @Override
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return eventService.getEventsByTitle(title, pageSize, pageNum);
    }

    @Override
    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return eventService.getEventsForDay(day, pageSize, pageNum);
    }

    @Override
    public Event createEvent(Event event) {
        return eventService.createEvent(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventService.updateEvent(event);
    }

    @Override
    public boolean deleteEvent(long eventId) {
        return eventService.deleteEvent(eventId);
    }

    @Override
    public User getUserById(long userId) {
        return userService.getUserById(userId);
    }

    @Override
    public User getUserByEmail(String email) {
        return userService.getUserByEmail(email);
    }

    @Override
    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return userService.getUsersByName(name, pageSize, pageNum);
    }

    @Override
    public User createUser(User user) {
        return userService.createUser(user);
    }

    @Override
    public User updateUser(User user) {
        return userService.updateUser(user);
    }

    @Override
    public boolean deleteUser(long userId) {
        return userService.deleteUser(userId);
    }

    @Override
    public Ticket bookTicket(long userId, long eventId, int place, Ticket.Category category) {
        return ticketService.bookTicket(userId, eventId, place, category);
    }

    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return ticketService.getBookedTickets(user, pageSize, pageNum);
    }

    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return ticketService.getBookedTickets(event, pageSize, pageNum);
    }

    @Override
    public boolean cancelTicket(long ticketId) {
        return ticketService.cancelTicket(ticketId);
    }

    public UserAccount getUserAccountByUserId(long userId){
        return userAccountService.getUserAccountByUserId(userId);
    }

    public UserAccountEntity getUserAccountById(long id){
        return userAccountService.getUserAccountById(id);
    }

    public UserAccount updateUserAccount(UserAccountEntity userAccount){
        return userAccountService.updateUserAccount(userAccount);
    }

    public void deleteUserAccount(long id){
        userAccountService.deleteUserAccount(id);
    }
}
