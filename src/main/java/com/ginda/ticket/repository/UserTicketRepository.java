package com.ginda.ticket.repository;

import com.ginda.ticket.model.UserTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTicketRepository extends JpaRepository<UserTicket, Integer> {
    List<UserTicket> findUserTicketByUserId(int userId);

    @Query("select coalesce(max(id), 0) id from UserTicket")
    List<Integer> findCurrentId();
}
