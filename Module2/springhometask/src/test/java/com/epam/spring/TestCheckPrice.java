package com.epam.spring;

import com.epam.spring.domain.factory.EventFactory;
import com.epam.spring.model.Event;
import com.epam.spring.utils.CommonTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Date;

public class TestCheckPrice extends CommonTest{

    @Before
    public void init(){
        initListOfEvents();
        initEventFacade();
    }

    @Ignore
    @Test
    public void testNewTicketPrice(){
        Event eventExample = new EventFactory().createEvent("updatedEventTitle", new Date(2017, 12, 13));
        Assert.assertEquals(eventExample.getTitle(), bookingService.getEventById(1).getTitle());
    }

}
