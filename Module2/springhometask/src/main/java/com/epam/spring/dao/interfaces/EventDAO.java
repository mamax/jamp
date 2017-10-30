package com.epam.spring.dao.interfaces;

import com.epam.spring.domain.EventEntity;

import java.util.Date;
import java.util.List;

public interface EventDAO {

    EventEntity getEventById(long eventId);
    List<EventEntity> getEventsByTitle(String title);
    List<EventEntity> getEventsForDay(Date day);
    EventEntity createEvent(EventEntity eventEntity);
    EventEntity updateEvent(EventEntity eventEntity);
    boolean deleteEvent(long eventId);
}
