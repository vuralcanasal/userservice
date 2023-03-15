package com.catdog.userservice.repository;

import com.catdog.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    @Query("SELECT u FROM User u WHERE u.account.id =?1")
    Optional <User> findUserByAccountId(String accountId);
}
