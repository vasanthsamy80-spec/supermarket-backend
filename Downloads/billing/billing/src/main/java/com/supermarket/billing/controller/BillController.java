package com.supermarket.billing.controller;

import com.supermarket.billing.model.Bill;
import com.supermarket.billing.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/bills")
public class BillController {

    @Autowired
    private BillRepository repo;

    // Save bill
    @PostMapping
    public Bill saveBill(@RequestBody Bill bill) {
        return repo.save(bill);
    }

    // Get all bills
    @GetMapping
    public List<Bill> getAllBills() {
        return repo.findAll();
    }

    // Clear all history
    @DeleteMapping("/clear")
    public String clearBills() {
        repo.deleteAll();
        return "All Bills Deleted";
    }
}