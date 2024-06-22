package com.ginda.ticket.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@EqualsAndHashCode
public class Ticket {
    private int id;
    private String name;
    private int capacity;
    private int availability;
    private String salesBegin;
    private String salesEnd;

}
