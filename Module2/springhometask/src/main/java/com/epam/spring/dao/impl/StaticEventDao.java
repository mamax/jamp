package com.epam.spring.dao.impl;

import com.epam.spring.model.Event;
import com.epam.spring.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class StaticEventDao {

    @Autowired
    Repository repository;

    public Event getEventById(long eventId) {
        Event tempEvent = null;
        for (Map.Entry<Long, Object> entry : repository.getRepository().entrySet() ){
            if (entry.getKey().equals(eventId)){
                tempEvent = (Event) entry.getValue();
                break;
            }
        }
        return tempEvent;
    }

    public List<Event> getEventsByTitle(String title) {
        List<Event> events = new ArrayList<>();
        for (Map.Entry<Long, Object> entry : repository.getRepository().entrySet()){
            if (entry.getValue().toString().contains(title)){
                events.add((Event) entry.getValue());
            }
        }
        return events;
    }

    public List<Event> getEventsForDay(Date day) {
        List<Event> events = new ArrayList<>();
        for (Map.Entry<Long, Object> entry : repository.getRepository().entrySet()){
            Event event = (Event) entry.getValue();
            if (event.getDate().equals(day)){
                events.add(event);
            }
        }
        return events;
    }

    public void createEvent(Event eventEntity) {
        repository.put(eventEntity.getId(), eventEntity);
    }

    public Event updateEvent(Event eventEntity) {
        Event tempEvent = null;
        if (repository.getRepository().containsKey(eventEntity.getId())){
            tempEvent = (Event) repository.get(eventEntity.getId());

            tempEvent.setDate(eventEntity.getDate());

            tempEvent.setTitle(eventEntity.getTitle());
            repository.put(eventEntity.getId(), tempEvent);
        }

        return tempEvent;
    }

    public boolean deleteEvent(long eventId) {
        if (repository.getRepository().containsKey(eventId)){
            repository.delete(eventId);
            return true;
        }
        return false;
    }

}
