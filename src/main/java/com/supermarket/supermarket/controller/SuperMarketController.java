package com.supermarket.supermarket.controller;

import com.supermarket.supermarket.dto.SuperMarketDto;
import com.supermarket.supermarket.entity.Supermarket;
import com.supermarket.supermarket.mapper.SupermarketMapper;
import com.supermarket.supermarket.service.impl.SupermarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
//@RequestMapping("/api/v1")
public class SuperMarketController {

    @Autowired
    private final SupermarketService supermarketService;
    private final SupermarketMapper supermarketMapper;


    @GetMapping("/spuermarkets")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<SuperMarketDto>> findAll() {

        List<SuperMarketDto> Supermarket_dtos = supermarketMapper.mapToDto(supermarketService.getAllSuperMarkets());

        return new ResponseEntity<List<SuperMarketDto>>(Supermarket_dtos, HttpStatus.OK);
    }

    @PostMapping("/spuermarkets")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Supermarket> save(@RequestBody Supermarket supermarket) {


        Supermarket supermarkets = supermarketService.createSuperMarket(supermarket);

        return new ResponseEntity<Supermarket>(supermarkets, HttpStatus.OK);
    }
}
