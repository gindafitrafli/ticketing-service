package com.ginda.ticket.repository;

import com.ginda.ticket.model.UserTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserTicketRepository extends JpaRepository<UserTicket, Integer> {
    List<UserTicket> findUserTicketByUserId(int userId);

    @Query("select coalesce(max(id), 0) id from user_ticket")
    Integer getCurrentId();
}
