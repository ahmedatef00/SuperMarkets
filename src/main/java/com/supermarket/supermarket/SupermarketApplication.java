package com.supermarket.supermarket;

import com.supermarket.supermarket.config.FileStorageProperties;
//import com.supermarket.supermarket.config.SpringFoxConfig;
import com.supermarket.supermarket.controller.SuperMarketController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class})

public class SupermarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupermarketApplication.class, args);
    }

}
