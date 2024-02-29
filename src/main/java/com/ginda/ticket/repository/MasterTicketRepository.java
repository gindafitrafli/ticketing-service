package com.ginda.ticket.repository;

import com.ginda.ticket.model.MasterTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MasterTicketRepository extends JpaRepository<MasterTicket, Integer> {

    @Query("select coalesce(max(id), 0) id from master_ticket")
    Integer getCurrentId();

    @Query("update master_ticket m set m.availability = : availability where m.id = :id")
    void updateAvailability(int availability, int id);

}
