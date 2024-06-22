package com.ginda.ticket.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "USER_TICKET")
@Builder
@Getter
@Setter
@EqualsAndHashCode
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
