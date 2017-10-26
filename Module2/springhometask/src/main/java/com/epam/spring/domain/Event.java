package com.epam.spring.domain;

import java.util.Date;

public class Event extends  DomainObject{

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;

    public Date getDate() {
        return dateTime;
    }

    public void setDate(Date date) {
        this.dateTime = date;
    }

    private Date dateTime;

}
