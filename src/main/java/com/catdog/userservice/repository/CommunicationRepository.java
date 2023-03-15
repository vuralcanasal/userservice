package com.catdog.userservice.repository;

import com.catdog.userservice.model.Communication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommunicationRepository extends JpaRepository<Communication, String> {
    @Query("SELECT c FROM Communication c WHERE c.email =?1")
    Communication findCommunicationByEmail(String email);
}
