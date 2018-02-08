package com.epam.spring.domain;

import com.epam.spring.model.Event;

import java.util.Date;

public class EventEntity implements Event {

    private Long eventId;
    private String title;
    private Date dateTime;

    public EventEntity() {
    }

    @Override
    public long getId() {
        return eventId;
    }

    @Override
    public void setId(long id) {
        this.eventId=id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return dateTime;
    }

    public void setDate(Date date) {
        this.dateTime = date;
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
