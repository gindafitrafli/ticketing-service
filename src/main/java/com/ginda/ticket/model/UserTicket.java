package com.ginda.ticket.model;

import jakarta.persistence.*;

@Entity
@Table(name = "USER_TICKET")
public class UserTicket {
    //todo use id generator, using default sequence from posgtresql
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
    @JoinColumn(name = "user", nullable = false, insertable=false, updatable=false)
    private MasterUser user;

    @ManyToOne
    @JoinColumn(name = "ticket", nullable = false, insertable=false, updatable=false)
    private MasterTicket ticket;

    public UserTicket() {}

    public UserTicket(int id, int ticketId, int userId, int amount, MasterUser user
            , MasterTicket ticket
    ) {
        this.id = id;
        this.ticketId = ticketId;
        this.userId = userId;
        this.amount = amount;
        this.user = user;
        this.ticket = ticket;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public MasterUser getUser() {
        return user;
    }

    public void setUser(MasterUser user) {
        this.user = user;
    }

    public MasterTicket getTicket() {
        return ticket;
    }

    public void setTicket(MasterTicket ticket) {
        this.ticket = ticket;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
