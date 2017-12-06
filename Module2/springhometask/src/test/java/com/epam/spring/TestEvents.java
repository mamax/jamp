package com.epam.spring;

import com.epam.spring.domain.EventEntity;
import com.epam.spring.model.Event;
import com.epam.spring.utils.CommonTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestEvents extends CommonTest {

    @Before
    public void init(){
        initListOfEvents();
        initEventFacade();
    }

    @Test
    public void testCreateEvent(){
        Assert.assertEquals(events.size(), 2);
    }

    @Test
    public void testUpdateEvent(){
        Event eventExample = EventEntity.createEvent("updatedEventTitle", new Date(2017, 12, 13));
        eventExample.setId(1);
        bookingFacade.updateEvent(eventExample);
        Assert.assertEquals(eventExample.getTitle(), bookingFacade.getEventById(1).getTitle());
        Assert.assertEquals(eventExample.getDate(), bookingFacade.getEventById(1).getDate());
    }

    @Test
    public void testDeleteEvent(){
        bookingFacade.deleteEvent(0);
        Assert.assertEquals(null, bookingFacade.getEventById(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteEventWithWrongId() {
        bookingFacade.deleteEvent(-50);
    }

    @After
    public void tearDown(){
        repository.getRepository().remove(0);
        repository.getRepository().remove(1);
    }

}
