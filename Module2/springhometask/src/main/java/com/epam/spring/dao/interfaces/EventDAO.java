package com.epam.spring.dao.interfaces;

import com.epam.spring.model.Event;

import java.util.Date;
import java.util.List;

public interface EventDAO {

    Event getEventById(long eventId);
    List<Event> getEventsByTitle(String title);
    List<Event> getEventsForDay(Date day);
    Event createEvent(Event eventEntity);
    Event updateEvent(Event eventEntity);
    boolean deleteEvent(long eventId);
}
