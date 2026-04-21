package com.supermarket.billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.supermarket.billing.model.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {
}