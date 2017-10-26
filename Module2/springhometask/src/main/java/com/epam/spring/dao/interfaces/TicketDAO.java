package com.epam.spring.dao.interfaces;

import com.epam.spring.domain.EventObject;
import com.epam.spring.domain.TicketObject;
import com.epam.spring.domain.UserObject;

import java.util.List;

public interface TicketDAO {

    TicketObject createTicket(TicketObject ticketObject);
    List<TicketObject> getBookedTickets(UserObject userObject);
    List<TicketObject> getBookedTickets(EventObject eventObject);
    boolean cancelTicket(long ticketId);

}
