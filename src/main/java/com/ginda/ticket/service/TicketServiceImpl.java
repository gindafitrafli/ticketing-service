package com.ginda.ticket.service;

import com.ginda.ticket.dto.Ticket;
import com.ginda.ticket.dto.request.TicketOrder;
import com.ginda.ticket.exception.BadRequestException;
import com.ginda.ticket.exception.NotFoundException;
import com.ginda.ticket.model.MasterTicket;
import com.ginda.ticket.model.MasterUser;
import com.ginda.ticket.model.UserTicket;
import com.ginda.ticket.repository.MasterTicketRepository;
import com.ginda.ticket.repository.MasterUserRepository;
import com.ginda.ticket.repository.UserTicketRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");

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
        ticket.setId(masterTicketRepository.findCurrentId().get(0) + 1);
        masterTicketRepository.save(convertTicketToMasterTicket(ticket));
    }

    @Override
    public void orderTicket(int ticketId, TicketOrder ticketOrder) {
        MasterUser user = addUser(ticketOrder);
        var a = "and sales_begin >= :salesBegin and sales_end >= :salesEnd";
        Optional<MasterTicket> masterTicket = masterTicketRepository.findById(ticketId);

        try {
            validateOder(ticketOrder, masterTicket);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        }

        masterTicketRepository.updateAvailability(
                masterTicket.get().getAvailability() - ticketOrder.getQuantity(),
                ticketId
        );

        userTicketRepository.save(
                new UserTicket(
                        userTicketRepository.findCurrentId().get(0)+1,
                        masterTicket.get().getId(),
                        user.getId()
                )
        );

    }

    private List<Ticket> convertListOfMasterTicketToListOfTicket(List<MasterTicket> retrievedTicket) {
        List<Ticket> ticketList = new ArrayList<>(retrievedTicket.size());
        retrievedTicket.forEach(
                masterTicket -> ticketList.add(
                        new Ticket(
                                masterTicket.getId(),
                                masterTicket.getName(),
                                masterTicket.getCapacity(),
                                masterTicket.getAvailability(),
                                convertDateToDateString(masterTicket.getSalesBegin().getTime()),
                                convertDateToDateString(masterTicket.getSalesEnd().getTime())
                        )
                )
        );
        return ticketList;
    }

    private MasterTicket convertTicketToMasterTicket(Ticket ticket) {
        return new MasterTicket(
                ticket.getId(),
                ticket.getName(),
                ticket.getAvailability(),
                ticket.getCapacity(),
                Timestamp.valueOf(ticket.getSalesBegin()),
                Timestamp.valueOf(ticket.getSalesEnd())
        );

    }

    private static String convertDateToDateString(long time) {

        return SIMPLE_DATE_FORMAT.format(new Date(time));
    }

    private MasterUser addUser(TicketOrder ticketOrder) {
        if (masterUserRepository.findUserByName(ticketOrder.getUserName()).isEmpty()) {
            MasterUser user = new MasterUser(
                    masterUserRepository.findCurrentId().get(0) + 1,
                    ticketOrder.getUserName()
            );
            masterUserRepository.save(user);
            return user;
        }
        return masterUserRepository.findUserByName(ticketOrder.getUserName()).get();
    }

    private void validateOder(TicketOrder ticketOrder, Optional<MasterTicket> masterTicket)
            throws NotFoundException, BadRequestException {
        if (masterTicket.isEmpty()) {
            throw new NotFoundException("ticket not found.");
        }
        if (
                masterTicket.get().getSalesBegin().compareTo(Timestamp.valueOf(LocalDateTime.now(Clock.systemUTC()))) == -1
                        || masterTicket.get().getSalesBegin().compareTo(Timestamp.valueOf(LocalDateTime.now(Clock.systemUTC()))) == -1) {
            throw new BadRequestException("ticket cannot be ordered.");
        }
        if (masterTicket.get().getCapacity()<ticketOrder.getQuantity()) {
            throw new NotFoundException("limited ticket.");
        }
    }

}
