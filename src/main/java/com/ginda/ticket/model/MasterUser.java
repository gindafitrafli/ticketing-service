package com.ginda.ticket.model;

import com.ginda.ticket.dto.Ticket;
import com.ginda.ticket.dto.response.User;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "MASTER_USER")
public class MasterUser {

    //todo use id generator, using default sequence from posgtresql
    @Id
    @Column(name = "ID")
    private int id;
    @Column(name = "NAME")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<UserTicket> orderedTickets;

    public MasterUser() {}

    public MasterUser(int id, String name, List<UserTicket> orderedTickets) {
        this.id = id;
        this.name = name;
        this.orderedTickets = orderedTickets;
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

    public List<UserTicket> getOrderedTickets() {
        return orderedTickets;
    }

    public void setOrderedTickets(List<UserTicket> orderedTickets) {
        this.orderedTickets = orderedTickets;
    }
}
