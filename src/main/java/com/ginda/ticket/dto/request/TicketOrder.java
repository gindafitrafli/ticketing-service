package com.ginda.ticket.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TicketOrder {
    private String userName;
    private int quantity;
}
