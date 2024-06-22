package com.ginda.ticket.service;

import com.ginda.ticket.dto.Ticket;
import com.ginda.ticket.dto.request.TicketOrder;
import com.ginda.ticket.exception.BadRequestException;
import com.ginda.ticket.exception.NotFoundException;
import com.ginda.ticket.exception.UnprocessableEntityException;
import com.ginda.ticket.model.MasterTicket;
import com.ginda.ticket.model.MasterUser;
import com.ginda.ticket.model.UserTicket;
import com.ginda.ticket.repository.MasterTicketRepository;
import com.ginda.ticket.repository.MasterUserRepository;
import com.ginda.ticket.repository.UserTicketRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TicketServiceImpl implements TicketService {

    private final UserTicketRepository userTicketRepository;
    private final MasterTicketRepository masterTicketRepository;
    private final MasterUserRepository masterUserRepository;
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public TicketServiceImpl(
            UserTicketRepository userTicketRepository,
            MasterTicketRepository masterTicketRepository,
            MasterUserRepository masterUserRepository
    ) {
        this.userTicketRepository = userTicketRepository;
        this.masterTicketRepository = masterTicketRepository;
        this.masterUserRepository = masterUserRepository;
    }

    @Override
    public List<Ticket> getAllTicket() {
        return convertListOfMasterTicketToListOfTicket(masterTicketRepository.findAll());
    }

    @Override
    public void createTicket(Ticket ticket) {
//        ticket.setId(masterTicketRepository.findCurrentId().get(0) + 1);
//        validateCreateTicket(ticket);
//        masterTicketRepository.save(convertTicketToMasterTicket(ticket));
    }

    @Transactional
    @Override
    public void orderTicket(String ticketName, TicketOrder ticketOrder) {
//        MasterUser user = addUser(ticketOrder);
//        Optional<MasterTicket> masterTicket = masterTicketRepository.findByName(ticketName);
//        validateOder(ticketOrder, masterTicket);
//
//        masterTicketRepository.updateAvailability(
//                masterTicket.get().getAvailability() - ticketOrder.getQuantity(),
//                masterTicket.get().getId()
//        );
//
//        userTicketRepository.save(
//                new UserTicket(
//                        userTicketRepository.findCurrentId().get(0) + 1,
//                        masterTicket.get().getId(),
//                        user.getId(),
//                        ticketOrder.getQuantity(),
//                        null
//                        , null //todo need checking
//                )
//        );

    }

    private List<Ticket> convertListOfMasterTicketToListOfTicket(List<MasterTicket> retrievedTicket) {
//        List<Ticket> ticketList = new ArrayList<>(retrievedTicket.size());
//        retrievedTicket.forEach(
//                masterTicket -> ticketList.add(
//                        new Ticket(
//                                masterTicket.getId(),
//                                masterTicket.getName(),
//                                masterTicket.getCapacity(),
//                                masterTicket.getAvailability(),
//                                convertDateToDateString(masterTicket.getSalesBegin().getTime()),
//                                convertDateToDateString(masterTicket.getSalesEnd().getTime())
//                        )
//                )
//        );
//        return ticketList;
        return null;
    }

    private MasterTicket convertTicketToMasterTicket(Ticket ticket) {
//        return new MasterTicket(
//                ticket.getId(),
//                ticket.getName(),
//                ticket.getCapacity(),
//                ticket.getCapacity(),
//                Timestamp.valueOf(ticket.getSalesBegin()),
//                Timestamp.valueOf(ticket.getSalesEnd())
//                ,
//                null //todo need checking
//        );

        return null;

    }

    private static String convertDateToDateString(long time) {

        return SIMPLE_DATE_FORMAT.format(new Date(time));
    }

    private MasterUser addUser(TicketOrder ticketOrder) {
//        if (masterUserRepository.findUserByName(ticketOrder.getUserName()).isEmpty()) {
//            MasterUser user = new MasterUser(
//                    masterUserRepository.findCurrentId().get(0) + 1,
//                    ticketOrder.getUserName(),
//                    null //todo need checking
//            );
//            masterUserRepository.save(user);
//            return user;
//        }
//        return masterUserRepository.findUserByName(ticketOrder.getUserName()).get();
    return null;
    }

    private void validateOder(TicketOrder ticketOrder, Optional<MasterTicket> masterTicket) {
//        log.error("invalid input.");
//        if (masterTicket.isEmpty()) {
//            throw new NotFoundException("ticket not found.");
//        }
//        if (
//                masterTicket.get().getSalesBegin().compareTo(Timestamp.valueOf(LocalDateTime.now(Clock.systemUTC()))) != -1
//                        || masterTicket.get().getSalesEnd().compareTo(Timestamp.valueOf(LocalDateTime.now(Clock.systemUTC()))) != 1) {
//            throw new BadRequestException("ticket cannot be ordered.");
//        }
//        if (masterTicket.get().getCapacity() < ticketOrder.getQuantity() || masterTicket.get().getCapacity() < ticketOrder.getQuantity()) {
//            throw new NotFoundException("limited ticket.");
//        }
    }
    private void validateCreateTicket(Ticket ticket) {
//        if (
//                ObjectUtils.isEmpty(ticket.getName()) ||
//                        ObjectUtils.isEmpty(ticket.getCapacity()) ||
//                        ObjectUtils.isEmpty(ticket.getSalesBegin()) ||
//                        ObjectUtils.isEmpty(ticket.getSalesEnd())
//        ) {
//            throw new UnprocessableEntityException("Invalid request body.");
//        }
    }

}
