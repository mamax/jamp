package com.epam.spring;

import com.epam.spring.domain.EventEntity;
import com.epam.spring.model.Event;
import com.epam.spring.utils.CommonTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class TestEvents extends CommonTest {

    @Before
    public void init(){
        initListOfEvents();
        initEventFacade();
    }

    @Test
    public void testCreateEvent(){
        Event event1 = events.get(0);
        Event event2 = bookingService.getEventById(0);
        Assert.assertEquals(event1, event2);
    }

    @Test
    public void testUpdateEvent(){
        Event eventExample = EventEntity.createEvent("updatedEventTitle", new Date(2017, 12, 13));
        eventExample.setId(1);
        bookingService.updateEvent(eventExample);
        Assert.assertEquals(eventExample.getTitle(), bookingService.getEventById(1).getTitle());
        Assert.assertEquals(eventExample.getDate(), bookingService.getEventById(1).getDate());
    }

    @Test
    public void testDeleteEvent(){
        bookingService.deleteEvent(1);
        Assert.assertEquals(null, bookingService.getEventById(1));
    }
}
