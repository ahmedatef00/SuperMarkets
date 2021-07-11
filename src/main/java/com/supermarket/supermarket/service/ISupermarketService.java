package com.supermarket.supermarket.service;

import com.supermarket.supermarket.dto.SuperMarketDto;
import com.supermarket.supermarket.entity.Supermarket;
import com.supermarket.supermarket.exception.SupermarketNotFoundException;

import java.util.List;


public interface ISupermarketService {


    public Supermarket createSuperMarket(Supermarket supermarket);

    Supermarket editSuperMarket(SuperMarketDto superMarketDto, Long id) throws SupermarketNotFoundException;

    void deleteSuperMarketByID(Long id) throws SupermarketNotFoundException;

    List<Supermarket> getAllSuperMarkets();


    Supermarket activate_deactivate(Long id, boolean active) throws SupermarketNotFoundException;
}
