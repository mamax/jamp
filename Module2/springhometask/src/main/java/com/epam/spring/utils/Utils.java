package com.epam.spring.utils;

import com.epam.spring.domain.UserAccountEntity;
import com.epam.spring.model.Event;
import com.epam.spring.model.Ticket;
import com.epam.spring.model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Utils {

    public static <T> List<T> getItemsFromPages(List<T> items, int pageSize, int pageNum) {

        List<T> itemsList;
        List<List<T>> listOfPages = new ArrayList<>();
        List<T> tempList = new ArrayList<>();

        if (items.size() <= pageSize){
            return items;
        }

        else if (items.size() > pageSize){
            for (T t : items){
                tempList.add(t);
                if (tempList.size() % pageSize == 0){
                    listOfPages.add(new ArrayList<>(tempList));
                    tempList.clear();
                }
            }
            listOfPages.add(new ArrayList<>(tempList));
        }

        itemsList = new ArrayList<T>((Collection<? extends T>) listOfPages);
        return itemsList;
    }

    public static boolean isEventIsValid(Event event) {
        return event!=null || !event.getTitle().isEmpty() || event.getDate() != null;
    }

    public static boolean isEventParametersIsValid(String title, int pageSize, int pageNum) {
        return !title.isEmpty() || isPageValid(pageSize, pageNum);
    }

    public static boolean isEventParametersIsValid(Date day, int pageSize, int pageNum) {
        return day != null || isPageValid(pageSize, pageNum);
    }

    private static boolean isPageValid(int pageSize, int pageNum) {
        return pageSize != 0 || pageNum != 0;
    }

    public static boolean isEventIdIsValid(long eventId) {
        return eventId >= 0;
    }

    public static boolean isUserIdIsValid(long userId) {
        return userId >= 0;
    }

    public static boolean isEmailIsValid(String email) {
        return !email.isEmpty();
    }

    public static boolean isUsersParametersIsValid(String name, int pageSize, int pageNum) {
        return !name.isEmpty() || isPageValid(pageSize, pageNum);
    }

    public static boolean isUserValid(User userEntity) {
        return !userEntity.getName().isEmpty() || userEntity.getName()!=null || !userEntity.getEmail().isEmpty() || userEntity.getEmail()!=null;
    }

    public static boolean isTicketParametersIsValid(long userId, long eventId, int place, Ticket.Category category) {
        return isUserIdIsValid(userId) || isEventIdIsValid(eventId) || place!=0 || category!=null;
    }

    public static boolean isTicketIsValid(User userEntity, int pageSize, int pageNum) {
        return isUserValid(userEntity) || isPageValid(pageSize, pageNum);
    }

    public static boolean isTicketIsValid(Event eventEntity, int pageSize, int pageNum) {
        return isEventIsValid(eventEntity) || isPageValid(pageSize, pageNum);
    }

    public static boolean isTicketIdIsValid(long ticketId) {
        return ticketId >= 0;
    }

    public static boolean isUserAccountValid(UserAccountEntity userAccount) {
        return isUserIdIsValid(userAccount.getId()) && userAccount!=null;
    }
}
