package com.epam.spring.storage;

import com.epam.spring.domain.EventEntity;
import com.epam.spring.domain.UserEntity;
import com.epam.spring.domain.wrapper.EventWrapper;
import com.epam.spring.domain.wrapper.UserWrapper;
import com.epam.spring.model.Event;
import com.epam.spring.model.User;
import com.epam.spring.utils.DataParser;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class InitStorage implements BeanPostProcessor {

    private static final String USER = "User";
    private static final String EVENT = "Event";

    Logger log = LoggerFactory.getLogger(InitStorage.class);

    File usersFile = new File("src\\test\\resources\\json\\users.json");

    File eventsFile = new File("src\\test\\resources\\json\\events.json");

    private JsonNode usersJsonNode;
    private JsonNode eventsJsonNode;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String s) throws BeansException {
        log.info("Before Initialization of bean {}", bean.getClass().getSimpleName());
        Map<String, Object> storage = new HashMap<>();

        if(bean.getClass().getSimpleName().equalsIgnoreCase("repository")){
            try {
                DataParser dataParser = new DataParser();
                usersJsonNode = dataParser.parseJsonNode(usersFile);
                eventsJsonNode = dataParser.parseJsonNode(eventsFile);

                UserWrapper astWr = dataParser.getWrapper(usersJsonNode, UserWrapper.class);

                for (UserEntity userEntity : astWr.getUsers()){
                    User user = UserEntity.createUser(userEntity.getId(), userEntity.getName(), userEntity.getEmail());
                    storage.put(USER + user.getId(), user);
                }

                EventWrapper eventWrapper = dataParser.getWrapper(eventsJsonNode, EventWrapper.class);

                for(EventEntity eventEntity : eventWrapper.getEvents()){
                    Event event = EventEntity.createEvent(eventEntity.getId(), eventEntity.getTitle(), eventEntity.getDate());
                    storage.put(EVENT + event.getId(), event);
                }

            } catch (FileNotFoundException e){
                log.error(e.getMessage(), e);

            }
        }
        return bean;
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String s) throws BeansException {
        log.info("After initialization of bean {}", bean.getClass().getSimpleName());
        return bean;
    }
}
