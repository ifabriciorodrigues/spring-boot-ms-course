package com.devsuperior.hroauth.service;

import com.devsuperior.hroauth.client.UserClient;
import com.devsuperior.hroauth.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserClient client;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = client.findByEmail(username).getBody();
        if (user == null) {
            throw new UsernameNotFoundException("Email not found");
        }

        return user;
    }
}
