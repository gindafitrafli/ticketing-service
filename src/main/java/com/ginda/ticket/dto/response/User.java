package com.ginda.ticket.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class User {
    private int id;
    private String name;
    private List<UserTicket> orderedTicket;

    public User(int id, String name, List<UserTicket> orderedTicket) {
        this.id = id;
        this.name = name;
        this.orderedTicket = orderedTicket;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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