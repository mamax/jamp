package com.epam.spring.domain;

import com.epam.spring.model.Event;

import java.util.Date;

public class EventEntity implements Event {

    private Long id;
    private String title;
    private Date date;

    public EventEntity() {
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static Event createEvent(String title, Date dateTime) {
        Event event = new EventEntity();
        event.setTitle(title);
        event.setDate(dateTime);
        return event;
    }

    public static Event createEvent(long id, String title, Date dateTime) {
        Event event = new EventEntity();
        event.setId(id);
        event.setTitle(title);
        event.setDate(dateTime);
        return event;
    }
}
