package com.supermarket.supermarket;

import com.supermarket.supermarket.entity.Role;
import com.supermarket.supermarket.entity.Supermarket;
import com.supermarket.supermarket.entity.User;
import com.supermarket.supermarket.repository.SupermarketRepository;
import com.supermarket.supermarket.service.impl.SupermarketService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
class SupermarketApplicationTests {
    @Autowired
    private SupermarketService supermarketService;
    @MockBean
    private SupermarketRepository supermarketRepository;

    @Test
    @DisplayName("Test FindAll")
    void testFindAll() {
//        Role role =new Role(1,"User");
//        User user = new User(1,"ahmed","a@a.com","1234567",role.);
//        Supermarket supermarket1 = new Supermarket(1L, "احمد", "atef", "address", "img.png", false,1);
//        Supermarket supermarket2 = new Supermarket(2L, "احمد2", "atef2", "2address", "2img.png", false,2);
//        doReturn(Arrays
//                .asList(supermarket1, supermarket2)).when(supermarketRepository).findAll();
//        List<Supermarket> supermarkets = supermarketService.getAllSuperMarkets();
//        Assertions.assertEquals(2, supermarkets.size());

    }

    @Test
    @DisplayName("Test Save Supermarket")
    void testSave() {
//        Supermarket supermarket1 = new Supermarket(1L, "احمد", "atef", "address", "img.png", false);
//        doReturn(supermarket1)
//                .when(supermarketRepository).save(any());
//        Supermarket returnedSupermarket = supermarketService.createSuperMarket(supermarket1);
//        Assertions.assertNotNull(supermarket1,"notnull");
//        Assertions.assertEquals(1, returnedSupermarket.getId(),"id");

    }
}
