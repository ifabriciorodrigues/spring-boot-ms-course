package com.devsuperior.hruser.controller;

import com.devsuperior.hruser.domain.User;
import com.devsuperior.hruser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userRepository.findById(id).get();
        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<User> findById(@RequestParam String email) {
        User user = userRepository.findByEmail(email);
        return ResponseEntity.ok(user);
    }
}

