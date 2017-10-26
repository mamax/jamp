package com.epam.spring.dao.interfaces;

import com.epam.spring.domain.EventObject;

import java.util.Date;
import java.util.List;

public interface EventDAO {

    EventObject getEventById(long eventId);
    List<EventObject> getEventsByTitle(String title);
    List<EventObject> getEventsForDay(Date day);
    EventObject createEvent(EventObject eventObject);
    EventObject updateEvent(EventObject eventObject);
    boolean deleteEvent(long eventId);
}
