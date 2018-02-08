package com.epam.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplicationContext {

    private ApplicationContext context;

    private void initContext() {
        context = new ClassPathXmlApplicationContext("spring-config.xml");
    }

    public static void main(String[] args) {
        SpringApplicationContext springApplicationContext = new SpringApplicationContext();
        springApplicationContext.initContext();
    }
}
