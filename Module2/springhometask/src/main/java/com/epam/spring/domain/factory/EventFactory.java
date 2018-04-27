package com.epam.spring.domain.factory;

import com.epam.spring.domain.EventEntity;
import com.epam.spring.model.Event;

import java.util.Date;

public class EventFactory  {

    public Event createEvent(String title, Date date){
        Event event = new EventEntity();
        event.setTitle(title);
        event.setDate(date);
        return event;
    }

    public Event createEvent(long id, String title, Date date){
        Event event = new EventEntity();
        event.setId(id);
        event.setTitle(title);
        event.setDate(date);
        return event;
    }

    public Event createEvent(long id, String title, Date date, long ticketPrice){
        Event event = new EventEntity();
        event.setId(id);
        event.setTitle(title);
        event.setDate(date);
        event.setTicketPrice(ticketPrice);
        return event;
    }


}
