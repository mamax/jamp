package com.epam.spring.domain;

import com.epam.spring.model.Event;

import java.util.Date;

public class EventEntity implements Event {

    @Override
    public long getId() {
        return eventId;
    }

    @Override
    public void setId(long id) {
        this.eventId=id;
    }

    private Long eventId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;

    public Date getDate() {
        return dateTime;
    }

    public void setDate(Date date) {
        this.dateTime = date;
    }

    private Date dateTime;

}
