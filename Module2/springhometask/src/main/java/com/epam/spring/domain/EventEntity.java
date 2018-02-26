package com.epam.spring.domain;

import com.epam.spring.model.Event;

import java.util.Date;

public class EventEntity implements Event {

    private long id;
    private String title;
    private Date date;
    private int ticketPrice;

    public EventEntity() {
    }

    public static Builder newBuilder(){
        return new EventEntity().new Builder();
    }

    public class Builder{
        private Builder(){
        }

        public Builder setId(long id){
            EventEntity.this.id = id;
            return this;
        }

        public Builder setTitle(String title){
            EventEntity.this.title = title;
            return this;
        }

        public Builder setDate(Date date){
            EventEntity.this.date = date;
            return this;
        }

        public Builder setTicketPrice(int ticketPrice){
            EventEntity.this.ticketPrice = ticketPrice;
            return this;
        }

        public EventEntity build(){
            return EventEntity.this;
        }

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

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

}
