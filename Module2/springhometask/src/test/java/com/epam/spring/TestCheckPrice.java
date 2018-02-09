package com.epam.spring;

import com.epam.spring.domain.EventEntity;
import com.epam.spring.model.Event;
import com.epam.spring.utils.CommonTest;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

//import org.junit.runner.RunWith;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
public class TestCheckPrice extends CommonTest{

    @Before
    public void init(){
        initListOfEvents();
        initEventFacade();
    }

    @Test
    public void testNewTicketPrice(){
        Event eventExample = EventEntity.createEvent("updatedEventTitle", new Date(2017, 12, 13));

//        Assert.assertEquals(eventExample.getTitle(), bookingFacade.getEventById(1).getTitle());
    }

}
