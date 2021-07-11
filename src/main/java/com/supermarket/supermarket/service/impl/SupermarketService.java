package com.supermarket.supermarket.service.impl;

import com.supermarket.supermarket.dto.SuperMarketDto;
import com.supermarket.supermarket.entity.Supermarket;
import com.supermarket.supermarket.exception.SupermarketNotFoundException;
import com.supermarket.supermarket.mapper.SupermarketMapper;
import com.supermarket.supermarket.repository.SupermarketRepository;
import com.supermarket.supermarket.service.ISupermarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Component
@RequiredArgsConstructor
public class SupermarketService implements ISupermarketService {

    @Autowired
    private final SupermarketRepository supermarketRepository;
    private final SupermarketMapper supermarketMapper;

//    public Supermarket save(Supermarket supermarket) {
//        return supermarketRepository.save(supermarket);
//    }

    @Override
    public Supermarket createSuperMarket(Supermarket supermarket) {
//        SuperMarketDto superMarketDto = supermarketMapper.mapToDto(supermarket);

//        Supermarket newSupermarket = storeImage(image, savedSupermarket);
        return supermarketRepository.save(supermarket);


    }

    @Override
    public Supermarket editSuperMarket(SuperMarketDto superMarketDto, Long id) throws SupermarketNotFoundException {

        Optional<Supermarket> supermarketOptional = supermarketRepository.findById(id);
        if (!supermarketOptional.isPresent()) {
            throw new SupermarketNotFoundException(id);
        } else {
            superMarketDto.getImage();
            Supermarket supermarket = supermarketMapper.mapToEntity(superMarketDto);
            return supermarketRepository.save(supermarket);
        }


    }

    @Override
    public void deleteSuperMarketByID(Long id) throws SupermarketNotFoundException {
        Optional<Supermarket> supermarketOptional = supermarketRepository.findById(id);
        if (!supermarketOptional.isPresent()) {
            throw new SupermarketNotFoundException(id);
        } else {
            supermarketRepository.deleteById(id);
        }
    }

    @Override
    public List<Supermarket> getAllSuperMarkets() {
        return supermarketRepository.findAll();
    }

    @Override
    public Supermarket activate_deactivate(Long id, boolean active) throws SupermarketNotFoundException {

        Optional<Supermarket> supermarketOptional = supermarketRepository.findById(id);
        if (!supermarketOptional.isPresent()) {
            throw new SupermarketNotFoundException(id);
        } else {
            supermarketOptional.get().setActive(active);
        }
        Supermarket supermarket = supermarketOptional.get();
        return supermarketRepository.save(supermarket);

    }
}
