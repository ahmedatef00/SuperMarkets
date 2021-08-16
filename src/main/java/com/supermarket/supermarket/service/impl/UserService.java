package com.supermarket.supermarket.service.impl;

import com.supermarket.supermarket.entity.User;
import com.supermarket.supermarket.repository.UserRepository;
import com.supermarket.supermarket.security.config.Filters.AuthenticationFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //GET List OF ALl Users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    //Get single user by id
    public User getUserById(Long id) {
        return userRepository.getById(id);
    }


    public void signup(User user) {
        if (!userRepository.existsByUsername(user.getUsername())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);

        }
    }
}
