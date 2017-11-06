package com.epam.spring.utils;

import com.epam.spring.service.BookingFacadeServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CommonTest {

    public final ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/resources/spring-config.xml");
    protected final BookingFacadeServiceImpl facade = (BookingFacadeServiceImpl) context.getBean("bookingService");
}
