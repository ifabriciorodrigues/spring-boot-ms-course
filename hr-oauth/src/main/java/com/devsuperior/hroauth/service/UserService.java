package com.devsuperior.hroauth.service;

import com.devsuperior.hroauth.client.UserClient;
import com.devsuperior.hroauth.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserClient client;

    public User findByEmail(String email) {
        User user = client.findByEmail(email).getBody();
        if (user == null) {
            throw new IllegalArgumentException("Email not found");
        }

        return user;
    }
}
