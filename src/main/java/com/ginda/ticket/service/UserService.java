package com.ginda.ticket.service;

import com.ginda.ticket.dto.response.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface UserService {
    User getUserTicket(String userName);
}
