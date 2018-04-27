package com.epam.spring.domain;

import com.epam.spring.model.Ticket;

public class TicketEntity implements Ticket{

    private long ticketId;
    private int place;
    private long userId;
    private long eventId;
    private Category category;

    public TicketEntity() {
    }

    @Override
    public String toString() {
        return "TicketEntity{" +
                "ticketId=" + ticketId +
                ", place=" + place +
                ", userId=" + userId +
                ", eventId=" + eventId +
                ", category=" + category +
                '}';
    }

    @Override
    public long getId() {
        return ticketId;
    }

    @Override
    public void setId(long id) {
        this.ticketId = id;
    }

    @Override
    public long getEventId() {
        return eventId;
    }

    @Override
    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    @Override
    public long getUserId() {
        return userId;
    }

    @Override
    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TicketEntity that = (TicketEntity) o;

        if (ticketId != that.ticketId) return false;
        if (getPlace() != that.getPlace()) return false;
        if (getUserId() != that.getUserId()) return false;
        if (getEventId() != that.getEventId()) return false;
        return getCategory() == that.getCategory();
    }

    @Override
    public int hashCode() {
        int result = (int) (ticketId ^ (ticketId >>> 32));
        result = 31 * result + getPlace();
        result = 31 * result + (int) (getUserId() ^ (getUserId() >>> 32));
        result = 31 * result + (int) (getEventId() ^ (getEventId() >>> 32));
        result = 31 * result + getCategory().hashCode();
        return result;
    }
}
