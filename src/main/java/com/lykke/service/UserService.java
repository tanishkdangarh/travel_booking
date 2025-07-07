package com.lykke.service;

import com.lykke.controller.LoginRequest;
import com.lykke.model.User;
import com.lykke.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void register(User user) {
        userRepository.save(user);
    }

    public boolean login(LoginRequest login) {
        System.out.println("Login request received: " + login);
        return userRepository.findByUsername(login.username)
                .map(u -> u.getPassword().equals(login.password))
                .orElse(false);
    }

    public User getProfile(String username) {
        return userRepository.findByUsername(username).orElseThrow();
    }

    public User updateProfile(User user) {
        return userRepository.save(user);
    }
}