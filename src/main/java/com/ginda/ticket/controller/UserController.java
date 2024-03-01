package com.ginda.ticket.controller;

import com.ginda.ticket.dto.response.User;
import com.ginda.ticket.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {
    private final UserService userService;

    public UserController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user/{userName}", produces = "application/json")
    public ResponseEntity<User> getUserTicket(@PathVariable String userName) {
        log.debug("getUserTicket {}", userName);
        return ResponseEntity.ok(userService.getUserTicket(userName));
    }
}
