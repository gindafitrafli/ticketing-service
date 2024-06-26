package com.ginda.ticket.repository;

import com.ginda.ticket.model.MasterTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MasterTicketRepository extends JpaRepository<MasterTicket, Integer> {


    Optional<MasterTicket> findByName(String name);


    /*@Query("update MasterTicket m set m.availability = :availability where m.id = :id")
    @Modifying
    void updateAvailability(@Param("availability")int availability, @Param("id")int id);*/
}
