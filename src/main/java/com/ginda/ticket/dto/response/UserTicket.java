package com.ginda.ticket.dto.response;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@EqualsAndHashCode
public class UserTicket {
    private String ticketName;
    private int orderedAmount;
}
