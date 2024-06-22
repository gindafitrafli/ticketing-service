package com.ginda.ticket.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "MASTER_TICKET")
public class MasterTicket {
    @Id
    @Column(name = "ID")
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "AVAILABILITY")
    private int availability;
    @Column(name = "CAPACITY")
    private int capacity;
    @Column(name = "SALES_BEGIN")
    private Timestamp salesBegin;
    @Column(name = "SALES_END")
    private Timestamp salesEnd;

}
