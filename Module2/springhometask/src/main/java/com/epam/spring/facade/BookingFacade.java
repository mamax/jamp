package com.epam.spring.facade;

import com.epam.spring.domain.EventEntity;
import com.epam.spring.domain.TicketEntity;
import com.epam.spring.domain.UserEntity;

import java.util.Date;
import java.util.List;

/**
 * Groups together all operations related to tickets booking.
 * Created by maksym_govorischev.
 */
public interface BookingFacade {

    /**
     * Gets event by its id.
     * @return EventEntity.
     */
    EventEntity getEventById(long eventId);

    /**
     * Get list of events by matching title. Title is matched using 'contains' approach.
     * In case nothing was found, empty list is returned.
     * @param title EventEntity title or it's part.
     * @param pageSize Pagination param. Number of events to return on a page.
     * @param pageNum Pagination param. Number of the page to return. Starts from 1.
     * @return List of events.
     */
    List<EventEntity> getEventsByTitle(String title, int pageSize, int pageNum);

    /**
     * Get list of events for specified day.
     * In case nothing was found, empty list is returned.
     * @param day Date object from which day information is extracted.
     * @param pageSize Pagination param. Number of events to return on a page.
     * @param pageNum Pagination param. Number of the page to return. Starts from 1.
     * @return List of events.
     */
    List<EventEntity> getEventsForDay(Date day, int pageSize, int pageNum);

    /**
     * Creates new eventEntity. EventEntity id should be auto-generated.
     * @param eventEntity EventEntity data.
     * @return Created EventEntity object.
     */
    EventEntity createEvent(EventEntity eventEntity);

    /**
     * Updates eventEntity using given data.
     * @param eventEntity EventEntity data for update. Should have id set.
     * @return Updated EventEntity object.
     */
    EventEntity updateEvent(EventEntity eventEntity);

    /**
     * Deletes event by its id.
     * @param eventId EventEntity id.
     * @return Flag that shows whether event has been deleted.
     */
    boolean deleteEvent(long eventId);

    /**
     * Gets user by its id.
     * @param userId UserEntity id.
     * @return UserEntity.
     */
    UserEntity getUserById(long userId);

    /**
     * Gets user by its email. Email is strictly matched.
     * @return UserEntity.
     */
    UserEntity getUserByEmail(String email);

    /**
     * Get list of users by matching name. Name is matched using 'contains' approach.
     * In case nothing was found, empty list is returned.
     * @param name Users name or it's part.
     * @param pageSize Pagination param. Number of users to return on a page.
     * @param pageNum Pagination param. Number of the page to return. Starts from 1.
     * @return List of users.
     */
    List<UserEntity> getUsersByName(String name, int pageSize, int pageNum);

    /**
     * Creates new userEntity. UserEntity id should be auto-generated.
     * @param userEntity UserEntity data.
     * @return Created UserEntity object.
     */
    UserEntity createUser(UserEntity userEntity);

    /**
     * Updates userEntity using given data.
     * @param userEntity UserEntity data for update. Should have id set.
     * @return Updated UserEntity object.
     */
    UserEntity updateUser(UserEntity userEntity);

    /**
     * Deletes user by its id.
     * @param userId UserEntity id.
     * @return Flag that shows whether user has been deleted.
     */
    boolean deleteUser(long userId);

    /**
     * Book ticket for a specified event on behalf of specified user.
     * @param userId UserEntity Id.
     * @param eventId EventEntity Id.
     * @param place Place number.
     * @param category Service category.
     * @return Booked ticket object.
     * @throws IllegalStateException if this place has already been booked.
     */
    TicketEntity bookTicket(long userId, long eventId, int place, TicketEntity.Category category);

    /**
     * Get all booked tickets for specified userEntity. Tickets should be sorted by event date in descending order.
     * @param userEntity UserEntity
     * @param pageSize Pagination param. Number of tickets to return on a page.
     * @param pageNum Pagination param. Number of the page to return. Starts from 1.
     * @return List of TicketEntity objects.
     */
    List<TicketEntity> getBookedTickets(UserEntity userEntity, int pageSize, int pageNum);

    /**
     * Get all booked tickets for specified eventEntity. Tickets should be sorted in by user email in ascending order.
     * @param eventEntity EventEntity
     * @param pageSize Pagination param. Number of tickets to return on a page.
     * @param pageNum Pagination param. Number of the page to return. Starts from 1.
     * @return List of TicketEntity objects.
     */
    List<EventEntity> getBookedTickets(EventEntity eventEntity, int pageSize, int pageNum);

    /**
     * Cancel ticket with a specified id.
     * @param ticketId TicketEntity id.
     * @return Flag whether anything has been canceled.
     */
    boolean cancelTicket(long ticketId);

}
