package com.ginda.ticket.dto.response;

import java.util.List;

public class User {
    private String name;
    private List<UserTicket> orderedTicket;

    public User(String name, List<UserTicket> orderedTicket) {
        this.name = name;
        this.orderedTicket = orderedTicket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserTicket> getOrderedTicket() {
        return orderedTicket;
    }

    public void setOrderedTicket(List<UserTicket> orderedTicket) {
        this.orderedTicket = orderedTicket;
    }
}