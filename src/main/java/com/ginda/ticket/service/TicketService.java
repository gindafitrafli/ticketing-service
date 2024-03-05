package com.ginda.ticket.service;

import com.ginda.ticket.dto.Ticket;
import com.ginda.ticket.dto.request.TicketOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.ParseException;
import java.util.Collections;
import java.util.List;

public interface TicketService {

    List<Ticket> getAllTicket();

    void createTicket(Ticket ticket);

    void orderTicket(String ticketName, TicketOrder ticketOrder);
}
