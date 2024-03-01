package com.ginda.ticket.service;

import com.ginda.ticket.dto.response.User;
import com.ginda.ticket.exception.NotFoundException;
import com.ginda.ticket.model.MasterTicket;
import com.ginda.ticket.model.MasterUser;
import com.ginda.ticket.model.UserTicket;
import com.ginda.ticket.repository.MasterTicketRepository;
import com.ginda.ticket.repository.MasterUserRepository;
import com.ginda.ticket.repository.UserTicketRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService{
    private final UserTicketRepository userTicketRepository;
    private final MasterUserRepository masterUserRepository;
    private final MasterTicketRepository masterTicketRepository;
    public UserServiceImpl(UserTicketRepository userTicketRepository, MasterUserRepository masterUserRepository, MasterTicketRepository masterTicketRepository) {
        this.userTicketRepository = userTicketRepository;
        this.masterUserRepository = masterUserRepository;
        this.masterTicketRepository = masterTicketRepository;
    }

    @Override
    public User getUserTicket(String userName) {
        Optional<MasterUser> user = masterUserRepository.findUserByName(userName);
        if (user.isEmpty()) {
            throw new NotFoundException("user not found");
        }
        List<UserTicket> userTicket = userTicketRepository.findUserTicketByUserId(user.get().getId());
        List<MasterTicket> ticketName = masterTicketRepository
                .findAllById(userTicket.stream().map(UserTicket::getTicketId).toList());





    }
}
