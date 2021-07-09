package com.supermarket.supermarket.service;

import com.supermarket.supermarket.dto.SuperMarketDto;
import com.supermarket.supermarket.entity.Supermarket;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ISupermarketService {


    Supermarket createSuperMarket(Supermarket supermarket);

    SuperMarketDto editSuperMarket(SuperMarketDto superMarketDto, Long id);

    void deleteSuperMarketByID(Long id);

    List<Supermarket> getAllSuperMarkets();


    SuperMarketDto activate_deactivate(Long id, boolean active);
}
