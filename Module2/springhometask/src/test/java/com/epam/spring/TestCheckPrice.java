package com.epam.spring;

import com.epam.spring.domain.EventEntity;
import com.epam.spring.model.Event;
import com.epam.spring.utils.CommonTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class TestCheckPrice extends CommonTest{

    @Before
    public void init(){
        initListOfEvents();
        initEventFacade();
    }

    @Test
    public void testNewTicketPrice(){
        Event eventExample = EventEntity.newBuilder().setTitle("updatedEventTitle").setDate(new Date(2017, 12, 13)).build();
        Assert.assertEquals(eventExample.getTitle(), bookingService.getEventById(1).getTitle());
    }

}
