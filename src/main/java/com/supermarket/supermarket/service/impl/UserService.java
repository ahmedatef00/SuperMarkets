package com.supermarket.supermarket.service.impl;

import com.supermarket.supermarket.entity.User;
import com.supermarket.supermarket.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Service
public class UserService {
    private UserRepository userRepository;

    //GET List OF ALl Users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    //Get single user by id
    public User getUserById(Integer id) {
        return userRepository.getById(id);
    }

//    public List<User> getUserByRoleName(String name) {
//        return userRepository.findUsersByRoleName(name);

//    }


}
