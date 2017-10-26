package com.epam.spring.domain;

public class Ticket extends DomainObject {

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    private int place;

    public enum Category {}
}
