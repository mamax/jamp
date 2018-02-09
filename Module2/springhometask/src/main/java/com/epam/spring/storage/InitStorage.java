package com.epam.spring.storage;

import com.epam.spring.domain.EventEntity;
import com.epam.spring.domain.UserEntity;
import com.epam.spring.domain.wrapper.EventWrapper;
import com.epam.spring.domain.wrapper.UserWrapper;
import com.epam.spring.model.Event;
import com.epam.spring.model.User;
import com.epam.spring.utils.JsonUtils;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import static com.epam.spring.namespace.Constants.EVENT;
import static com.epam.spring.namespace.Constants.USER;

public class InitStorage implements BeanPostProcessor {

    Logger log = LoggerFactory.getLogger(InitStorage.class);

    File usersFile = new File("src\\test\\resources\\json\\users.json");

    File eventsFile = new File("src\\test\\resources\\json\\events.json");

    private JsonNode usersJsonNode;
    private JsonNode eventsJsonNode;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String s) throws BeansException {
        log.info("Before Initialization of bean {}", bean.getClass().getSimpleName());
        Map<String, Object> repositoryMap = new HashMap<>();

        if(bean.getClass().getSimpleName().equalsIgnoreCase("Repository")){
            try {
                JsonUtils jsonUtils = new JsonUtils();
                usersJsonNode = jsonUtils.parseJsonNode(usersFile);
                eventsJsonNode = jsonUtils.parseJsonNode(eventsFile);

                UserWrapper astWr = jsonUtils.getWrapper(usersJsonNode, UserWrapper.class);

                for (UserEntity userEntity : astWr.getUsers()){
                    User user = UserEntity.createUser(userEntity.getId(), userEntity.getName(), userEntity.getEmail());
                    repositoryMap.put(USER + user.getId(), user);
                }

                EventWrapper eventWrapper = jsonUtils.getWrapper(eventsJsonNode, EventWrapper.class);

                for(EventEntity eventEntity : eventWrapper.getEvents()){
                    Event event = EventEntity.createEvent(eventEntity.getId(), eventEntity.getTitle(), eventEntity.getDate());
                    repositoryMap.put(EVENT + event.getId(), event);
                }

                Field repositoryFiled = bean.getClass().getDeclaredField("repository");
                repositoryFiled.setAccessible(true);
                ReflectionUtils.setField(repositoryFiled, bean, repositoryMap);

            } catch (NoSuchFieldException e) {
                e.printStackTrace();
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
