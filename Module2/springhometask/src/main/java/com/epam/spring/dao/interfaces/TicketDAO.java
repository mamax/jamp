package com.epam.spring.dao.interfaces;

import com.epam.spring.domain.EventEntity;
import com.epam.spring.domain.TicketEntity;
import com.epam.spring.domain.UserEntity;

import java.util.List;

public interface TicketDAO {

    TicketEntity createTicket(TicketEntity ticketEntity);
    List<TicketEntity> getBookedTickets(UserEntity userEntity);
    List<TicketEntity> getBookedTickets(EventEntity eventEntity);
    boolean cancelTicket(long ticketId);

}
