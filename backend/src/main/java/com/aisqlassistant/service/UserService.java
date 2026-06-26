package com.aisqlassistant.service;

import com.aisqlassistant.entity.User;
import com.aisqlassistant.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {

        return userRepository.findAll();

    }

    public User getUser(Long id) {

        return userRepository.findById(id)
                .orElseThrow();

    }

}