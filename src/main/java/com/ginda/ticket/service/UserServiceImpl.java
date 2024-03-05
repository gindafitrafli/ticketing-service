package com.ginda.ticket.service;

import com.ginda.ticket.dto.response.User;
import com.ginda.ticket.dto.response.UserTicket;
import com.ginda.ticket.exception.NotFoundException;
import com.ginda.ticket.model.MasterTicket;
import com.ginda.ticket.model.MasterUser;
import com.ginda.ticket.repository.MasterTicketRepository;
import com.ginda.ticket.repository.MasterUserRepository;
import com.ginda.ticket.repository.UserTicketRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService{
    private final MasterUserRepository masterUserRepository;

    public UserServiceImpl(MasterUserRepository masterUserRepository) {
        this.masterUserRepository = masterUserRepository;
    }

    @Override
    public User getUserTicket(String userName) {
        Optional<MasterUser> userData = masterUserRepository.findUserByName(userName);
        if (userData.isEmpty()) {
            throw new NotFoundException("user not found");
        }

        return convertToUserResponse(userData.get());

    }

    private User convertToUserResponse(MasterUser userData) {
        List<UserTicket> userTickets = new ArrayList<>(userData.getOrderedTickets().size());
        userData.getOrderedTickets().forEach(userTicket ->
                userTickets.add(new UserTicket(
                        "",
//                        userTicket.getTicket().getName(),
                        userTicket.getAmount()
                ))
        );
        return new User(userData.getName(), userTickets);
    }
}
