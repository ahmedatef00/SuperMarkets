package com.supermarket.supermarket;

import com.supermarket.supermarket.config.FileStorageProperties;
//import com.supermarket.supermarket.config.SpringFoxConfig;
import com.supermarket.supermarket.controller.SuperMarketController;
import com.supermarket.supermarket.entity.Role;
import com.supermarket.supermarket.entity.User;
import com.supermarket.supermarket.repository.RoleRepository;
import com.supermarket.supermarket.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class})

public class SupermarketApplication implements CommandLineRunner {
    @Autowired
    UserService userService;
    @Autowired
    RoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(SupermarketApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User admin = new User();
        admin.setId(1
        );
        admin.setUsername("admin");
        admin.setPassword("admin");

        Role adminRole = roleRepository.findByName("ROLE_ADMIN");

        admin.setRoles(new ArrayList<Role>(Arrays.asList(adminRole)));
//
        userService.signup(admin);
//
//        User client = new User();
//        client.setUsername("client");
//        client.setPassword("client");
//        client.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_CLIENT)));
//
//        userService.signup(client);

    }
}
