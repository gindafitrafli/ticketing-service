package com.ginda.ticket.repository;

import com.ginda.ticket.model.MasterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MasterUserRepository extends JpaRepository<MasterUser, Integer> {
    Optional<MasterUser> findUserByName(String userName);
    @Query("select coalesce(max(id), 0) id from MasterUser")
    List<Integer> findCurrentId();
}
