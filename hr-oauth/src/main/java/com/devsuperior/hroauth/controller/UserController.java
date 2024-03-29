package com.devsuperior.hroauth.controller;

import com.devsuperior.hroauth.domain.User;
import com.devsuperior.hroauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        try {
            User user = (User) service.loadUserByUsername(email);
            return ResponseEntity.ok(user);
        } catch (IllegalArgumentException err) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
