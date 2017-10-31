package com.epam.spring.service.implementation;

import com.epam.spring.dao.interfaces.EventDAO;
import com.epam.spring.model.Event;
import com.epam.spring.utils.Utils;

import java.util.Date;
import java.util.List;

public class EventServiceImpl {

    EventDAO eventDAO;

    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return Utils.getItemsFromPages(eventDAO.getEventsByTitle(title), pageSize, pageNum);
    }

    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return Utils.getItemsFromPages(eventDAO.getEventsForDay(day), pageSize, pageNum);
    }

    public Event createEvent(Event eventEntity) {
        return eventDAO.createEvent(eventEntity);
    }

    public Event updateEvent(Event eventEntity) {
        return eventDAO.updateEvent(eventEntity);
    }

    public boolean deleteEvent(long eventId) {
        return eventDAO.deleteEvent(eventId);
    }

    public Event getEventById(long eventId) {
        return eventDAO.getEventById(eventId);
    }
}
