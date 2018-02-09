package com.epam.spring.service;

import com.epam.spring.dao.impl.StaticEventDao;
import com.epam.spring.model.Event;
import com.epam.spring.utils.Utils;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EventServiceImpl {

    public EventServiceImpl() {
    }

    public void setEventDAO(StaticEventDao eventDAO) {
        this.eventDAO = eventDAO;
    }

    StaticEventDao eventDAO;
    private long eventId = 0;
    private static final Logger LOG = Logger.getLogger(EventServiceImpl.class.getName());

    public EventServiceImpl(StaticEventDao eventDAO) {
        this.eventDAO = eventDAO;
    }

    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        if (!Utils.isEventParametersIsValid(title, pageSize, pageNum)){
            LOG.log(Level.WARNING, String.format("Event with parameters %s, %d, %d is not valid", title, pageSize, pageNum));
            throw new IllegalArgumentException();
        }
        LOG.log(Level.INFO, "Get events by title:" + title);
        return Utils.getItemsFromPages(eventDAO.getEventsByTitle(title), pageSize, pageNum);
    }

    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        if (!Utils.isEventParametersIsValid(day, pageSize, pageNum)){
            LOG.log(Level.WARNING, String.format("Event with parameters %s, %d, %d is not valid", day, pageSize, pageNum));
            throw new IllegalArgumentException();
        }
        LOG.log(Level.INFO, "Get events by day:" + day);
        return Utils.getItemsFromPages(eventDAO.getEventsForDay(day), pageSize, pageNum);
    }

    public Event createEvent(Event eventEntity) {
        if (!Utils.isEventIsValid(eventEntity)){
            LOG.log(Level.WARNING, String.format("Event is not valid"));
            throw new IllegalArgumentException();
        }
        eventEntity.setId(eventId);
        eventDAO.createEvent(eventEntity);
        LOG.log(Level.INFO, "Created event: " + eventEntity);
        return eventEntity;
    }

    public Event updateEvent(Event eventEntity) {
        if (!Utils.isEventIsValid(eventEntity)){
            LOG.log(Level.WARNING, String.format("Event with  is not valid"));
            throw new IllegalArgumentException();
        }
        LOG.log(Level.INFO, "Updated event:" + eventEntity);
        return eventDAO.updateEvent(eventEntity);
    }

    public boolean deleteEvent(long eventId) {
        if (!Utils.isEventIdIsValid(eventId)){
            LOG.log(Level.WARNING, String.format("EventId is not valid"));
            throw new IllegalArgumentException();
        }
        LOG.log(Level.INFO, "Deleted event with id:" + eventId);
        return eventDAO.deleteEvent(eventId);
    }

    public Event getEventById(long eventId) {
        if (!Utils.isEventIdIsValid(eventId)){
            LOG.log(Level.WARNING, String.format("EventId is not valid"));
            throw new IllegalArgumentException();
        }
        LOG.log(Level.INFO, "Get event with id :" + eventId);
        return eventDAO.getEventById(eventId);
    }
}
