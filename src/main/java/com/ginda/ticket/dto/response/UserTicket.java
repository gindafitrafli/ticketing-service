package com.ginda.ticket.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserTicket {
    private int id;
    private String ticketName;

    public UserTicket(int id, String ticketName) {
        this.id = id;
        this.ticketName = ticketName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }
}
