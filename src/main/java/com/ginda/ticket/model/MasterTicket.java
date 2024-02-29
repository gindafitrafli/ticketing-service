package com.ginda.ticket.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

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

    public MasterTicket(int id, String name, int availability, int capacity, Timestamp salesBegin, Timestamp salesEnd) {
        this.id = id;
        this.name = name;
        this.availability = availability;
        this.capacity = capacity;
        this.salesBegin = salesBegin;
        this.salesEnd = salesEnd;
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

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Timestamp getSalesBegin() {
        return salesBegin;
    }

    public void setSalesBegin(Timestamp salesBegin) {
        this.salesBegin = salesBegin;
    }

    public Timestamp getSalesEnd() {
        return salesEnd;
    }

    public void setSalesEnd(Timestamp salesEnd) {
        this.salesEnd = salesEnd;
    }
}
