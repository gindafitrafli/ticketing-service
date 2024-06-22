package com.ginda.ticket.service;

import com.ginda.ticket.dto.Ticket;
import com.ginda.ticket.dto.request.TicketOrder;

import java.util.List;

public interface TicketService {

    List<Ticket> getAllTicket(String ticketName, boolean isCurrentlyAvailable, int minQty);

    void createTicket(Ticket ticket);

    void orderTicket(String ticketName, TicketOrder ticketOrder);
}
