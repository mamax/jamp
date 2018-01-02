package com.epam.spring.utils;

import com.epam.spring.model.Event;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class UtilsTest {

    private Event event1, event2, event3, event4, event5, event6, event7,eventUUH, sdcsdc, bsdcsbdc, dsfjj, event11;
    List<Event> eventList;

    @Before
    public void initList(){
        eventList = Arrays.asList(event1, event2, event3, event4, event5, event6, event7, eventUUH, sdcsdc, bsdcsbdc, dsfjj, event11);
    }

    @Test
    public void testShouldGetItemsFromPages(){
        Utils.getItemsFromPages(eventList, 5, 3);

    }

}