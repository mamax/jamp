package com.epam.spring.service.model;

import java.util.Date;

/**
 * Created by maksym_govorischev.
 */
public interface EventService {
    /**
     * EventServiceImpl id. UNIQUE.
     * @return EventServiceImpl Id
     */
    long getId();
    void setId(long id);
    String getTitle();
    void setTitle(String title);
    Date getDate();
    void setDate(Date date);
}
