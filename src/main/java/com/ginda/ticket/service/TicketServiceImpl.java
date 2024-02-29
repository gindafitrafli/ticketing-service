package com.ginda.ticket.service;

import com.ginda.ticket.dto.Ticket;
import com.ginda.ticket.dto.request.TicketOrder;
import com.ginda.ticket.model.MasterTicket;
import com.ginda.ticket.model.MasterUser;
import com.ginda.ticket.repository.MasterTicketRepository;
import com.ginda.ticket.repository.MasterUserRepository;
import com.ginda.ticket.repository.UserTicketRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        ticket.setId(masterTicketRepository.getCurrentId() + 1);
        masterTicketRepository.save(convertTicketToMasterTicket(ticket));
    }

    @Override
    public void orderTicket(int ticketId, TicketOrder ticketOrder) {
        addUser(ticketOrder);
        var a = "and sales_begin >= :salesBegin and sales_end >= :salesEnd";
        Optional<MasterTicket> masterTicket = masterTicketRepository.findById(ticketId);

        validateOder(ticketOrder, masterTicket);
//        masterTicketRepository.updateAvailability();


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
//        try {
            return new MasterTicket(
                    ticket.getId(),
                    ticket.getName(),
                    ticket.getAvailability(),
                    ticket.getCapacity(),
                    Timestamp.valueOf(ticket.getSalesBegin()),
                    Timestamp.valueOf(ticket.getSalesEnd())
            );
//        } catch (ParseException e) {
//            log.error(e.getMessage(), e);
//            throw e;
//        }
    }

    private static String convertDateToDateString(long time) {

        return SIMPLE_DATE_FORMAT.format(new Date(time));
    }

    private void addUser(TicketOrder ticketOrder) {
        if (masterUserRepository.findUserByName(ticketOrder.getUserName()).isEmpty()) {
            masterUserRepository.save(
                    new MasterUser(
                            masterUserRepository.getCurrentId() + 1,
                            ticketOrder.getUserName()
                    )
            );
        }
    }

    private void validateOder(TicketOrder ticketOrder, Optional<MasterTicket> masterTicket) {
//        if
    }

}
