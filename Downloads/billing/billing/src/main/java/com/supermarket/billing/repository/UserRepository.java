package com.supermarket.billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.supermarket.billing.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}