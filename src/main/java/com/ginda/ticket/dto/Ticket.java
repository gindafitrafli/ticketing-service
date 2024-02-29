package com.ginda.ticket.dto;

public class Ticket {
    private int id;
    private String name;
    private int capacity;
    private int availability;
    private String salesBegin;
    private String salesEnd;

    public Ticket(int id, String name, int capacity, int availability, String salesBegin, String salesEnd) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.availability = availability;
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public String getSalesBegin() {
        return salesBegin;
    }

    public void setSalesBegin(String salesBegin) {
        this.salesBegin = salesBegin;
    }

    public String getSalesEnd() {
        return salesEnd;
    }

    public void setSalesEnd(String salesEnd) {
        this.salesEnd = salesEnd;
    }
}
