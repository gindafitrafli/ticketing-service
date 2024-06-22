package com.ginda.ticket.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserTicket {
    private String ticketName;
    private int orderedAmount;
}
