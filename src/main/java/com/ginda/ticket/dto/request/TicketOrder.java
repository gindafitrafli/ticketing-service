package com.ginda.ticket.dto.request;


public class TicketOrder {
    private String userName;
    private int quantity;
    public TicketOrder() {}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
