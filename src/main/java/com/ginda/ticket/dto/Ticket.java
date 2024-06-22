package com.ginda.ticket.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Ticket {
    private int id;
    private String name;
    private int capacity;
    private int availability;
    private String salesBegin;
    private String salesEnd;

}
