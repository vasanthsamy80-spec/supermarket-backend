package com.supermarket.billing.controller;

import com.supermarket.billing.model.User;
import com.supermarket.billing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository repo;

    // ✅ REGISTER
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return repo.save(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {

        User existing = repo.findByUsername(user.getUsername());

        if (existing != null &&
                existing.getPassword().equals(user.getPassword())) {

            return existing;   // returns username + role
        }

        return null;
    }
    @PutMapping("/reset-password")
    public String resetPassword(@RequestBody User user) {

        User existing = repo.findByUsername(user.getUsername());

        if (existing != null) {
            existing.setPassword(user.getPassword());
            repo.save(existing);
            return "Password Reset Success";
        }

        return "User Not Found";
    }

}