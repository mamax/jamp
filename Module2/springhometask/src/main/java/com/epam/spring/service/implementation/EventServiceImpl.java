package com.epam.spring.service.implementation;

import com.epam.spring.domain.Event;
import com.epam.spring.service.model.EventService;

import java.util.Date;

public class EventServiceImpl implements EventService {

    private Event event;

    public long getId() {
        return event.getId();
    }

    public void setId(long id) {
            event.setId(id);
    }

    public String getTitle() {
        return event.getTitle();
    }

    public void setTitle(String title) {
            event.setTitle(title);
    }

    public Date getDate() {
        return event.getDate();
    }

    public void setDate(Date date) {
        event.setDate(date);
    }
}
