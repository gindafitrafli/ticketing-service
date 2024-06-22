package com.ginda.ticket.model;

import com.ginda.ticket.dto.Ticket;
import com.ginda.ticket.dto.response.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "MASTER_USER")
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class MasterUser {

    @Id
    @Column(name = "ID")
    private int id;
    @Column(name = "NAME")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<UserTicket> orderedTickets;

    public MasterUser() {}

}
