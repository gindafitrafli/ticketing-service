package com.ginda.ticket.dto.response;

public class UserTicket {
    private String ticketName;
    private int orderedAmount;

    public UserTicket(String ticketName, int orderedAmount) {
        this.ticketName = ticketName;
        this.orderedAmount = orderedAmount;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public int getOrderedAmount() {
        return orderedAmount;
    }

    public void setOrderedAmount(int orderedAmount) {
        this.orderedAmount = orderedAmount;
    }
}
