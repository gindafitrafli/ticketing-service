package com.ginda.ticket.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class User {
    private String name;
    private List<UserTicket> orderedTicket;

}