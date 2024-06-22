package com.ginda.ticket.model;

import jakarta.persistence.*;

@Entity
@Table(name = "USER_TICKET")
public class UserTicket {

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "TICKET_ID")
    private int ticketId;
    @Column(name = "USER_ID")
    private int userId;

    @Column(name = "AMOUNT")
    private int amount;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private MasterUser user;

    @ManyToOne
    @JoinColumn(name = "TICKET_ID")
    private MasterTicket ticket;

}
