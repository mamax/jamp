package com.epam.spring.service.model;

/**
 * Created by maksym_govorischev.
 */
public interface TicketService {
    enum Category {STANDARD, PREMIUM, BAR}

    /**
     * TicketService Id. UNIQUE.
     * @return TicketService Id.
     */
    long getId();
    void setId(long id);
    long getEventId();
    void setEventId(long eventId);
    long getUserId();
    void setUserId(long userId);
    Category getCategory();
    void setCategory(Category category);
    int getPlace();
    void setPlace(int place);

}
