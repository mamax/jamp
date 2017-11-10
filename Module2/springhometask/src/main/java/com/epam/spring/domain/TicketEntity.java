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

    public TicketEntity(long ticketId, int place, long userId, long eventId, Category category) {
        this.ticketId = ticketId;
        this.place = place;
        this.userId = userId;
        this.eventId = eventId;
        this.category = category;
    }

    public static Ticket createNewTicket(long ticketId, long userId, long eventId, int place, Category category) {
        Ticket ticket = new TicketEntity();
        ticket.setId(ticketId);
        ticket.setEventId(eventId);
        ticket.setUserId(userId);
        ticket.setPlace(place);
        ticket.setCategory(category);
        return ticket;
    }

    public static class Builder{
        private long ticketId;
        private long userId;
        private long eventId;
        private Category category;
        private int place;

        public Builder setPlace(int place) {
            this.place = place;
            return this;
        }

        public Builder setUserId(long userId) {
            this.userId = userId;
            return this;
        }

        public Builder setEventId(long eventId) {
            this.eventId = eventId;
            return this;
        }

        public Builder setCategory(Category category) {
            this.category = category;
            return this;
        }

        public Builder setId(long id){
            this.ticketId = id;
            return this;
        }

        public TicketEntity build(){return new TicketEntity(ticketId, place, userId, eventId, category);}

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
