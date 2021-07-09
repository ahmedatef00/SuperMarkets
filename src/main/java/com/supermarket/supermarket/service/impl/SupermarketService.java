package com.supermarket.supermarket.service.impl;

import com.supermarket.supermarket.dto.SuperMarketDto;
import com.supermarket.supermarket.entity.Supermarket;
import com.supermarket.supermarket.mapper.SupermarketMapper;
import com.supermarket.supermarket.repository.SupermarketRepository;
import com.supermarket.supermarket.service.ISupermarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Component
@RequiredArgsConstructor
public class SupermarketService implements ISupermarketService {

    @Autowired
    private final SupermarketRepository supermarketRepository;
    private final SupermarketMapper supermarketMapper;

    @Override
    public Supermarket createSuperMarket(Supermarket supermarket) {

        return supermarketRepository.save(supermarket);
    }

    @Override
    public SuperMarketDto editSuperMarket(SuperMarketDto superMarketDto, Long id) {
        return null;
    }

    @Override
    public void deleteSuperMarketByID(Long id) {

    }

    @Override
    public List<Supermarket> getAllSuperMarkets() {
//        List<SuperMarketDto> dtos = supermarketMapper.mapToDto(supermarketRepository.findAll());
//        return dtos;
        return supermarketRepository.findAll();
    }

    @Override
    public SuperMarketDto activate_deactivate(Long id, boolean active) {
        return null;
    }
}
