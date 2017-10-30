package com.epam.spring.service.implementation;

import com.epam.spring.domain.EventEntity;
import com.epam.spring.model.Event;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventServiceImpl {

    private static Map<Long, Event> eventMap = new HashMap<>();

    public List<EventEntity> getEventsForDay(Date day, int pageSize, int pageNum) {
        return null;
    }

    public List<EventEntity> getEventsByTitle(String title, int pageSize, int pageNum) {
        return null;
    }

    public EventEntity createEvent(EventEntity eventEntity) {
        return null;
    }

    public EventEntity updateEvent(EventEntity eventEntity) {
        return null;
    }

    public boolean deleteEvent(long eventId) {
        return false;
    }

    public EventEntity getEventById(long eventId) {
        return null;
    }
}
