package com.ginda.ticket.controller;

import com.ginda.ticket.dto.Ticket;
import com.ginda.ticket.dto.request.TicketOrder;
import com.ginda.ticket.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class TicketController {

    private final TicketService ticketService;
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping(value = "/ticket", produces = {"application/json"})
    public ResponseEntity<List<Ticket>> getTicket(
            @RequestParam(value = "name") String ticketName,
            @RequestParam(value = "currently-available") boolean isCurrentlyAvailable,
            @RequestParam(value = "min-qty") int minQty
    ) {
        log.debug("getAllTicket");
        return ResponseEntity.ok(ticketService.getAllTicket(ticketName, isCurrentlyAvailable, minQty));
    }

    @PostMapping(value = "/ticket", consumes = {"application/json"})
    public ResponseEntity<Void> createTicket(@RequestBody Ticket ticket)  {
        log.debug("createTicket");

        ticketService.createTicket(ticket);

        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/ticket/{ticketName}", produces =  {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<Void> orderTicket(@PathVariable String ticketName, @RequestBody TicketOrder ticketOrder) {
        log.debug("orderTicket {} {} {}", ticketName, ticketOrder.getQuantity(), ticketOrder.getUserName());
        ticketService.orderTicket(ticketName, ticketOrder);
        return ResponseEntity.ok().build();
    }

}
