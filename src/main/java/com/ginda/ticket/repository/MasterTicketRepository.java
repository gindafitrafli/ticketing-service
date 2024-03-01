package com.ginda.ticket.repository;

import com.ginda.ticket.model.MasterTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MasterTicketRepository extends JpaRepository<MasterTicket, Integer> {

    @Query("select coalesce(max(id), 0) id from MasterTicket")
    List<Integer> findCurrentId();

    @Query("update MasterTicket m set m.availability = :availability where m.id = :id")
    void updateAvailability(@Param("availability")int availability, @Param("id")int id);

}
