package com.supermarket.supermarket.service.impl;

import com.supermarket.supermarket.entity.User;
import com.supermarket.supermarket.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired

    //GET List OF ALl Users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    //Get single user by id
    public User getUserById(Integer id) {
        return userRepository.getById(id);
    }

    public List<User> getUserByRoleName(String name) {
        return userRepository.findUsersByRoleName(name);

    }


}
