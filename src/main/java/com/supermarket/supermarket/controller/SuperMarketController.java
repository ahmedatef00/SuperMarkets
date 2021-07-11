package com.supermarket.supermarket.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.supermarket.supermarket.dto.SuperMarketDto;
import com.supermarket.supermarket.entity.Supermarket;
import com.supermarket.supermarket.exception.SupermarketNotFoundException;
import com.supermarket.supermarket.mapper.SupermarketMapper;
import com.supermarket.supermarket.service.impl.FileStorageService;
import com.supermarket.supermarket.service.impl.SupermarketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j

//@RequestMapping("/api/v1")
public class SuperMarketController {

    @Autowired
    private final SupermarketService supermarketService;
    @Autowired
    private final FileStorageService fileStorageService;
    private final SupermarketMapper supermarketMapper;

    ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/supermarkets")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<SuperMarketDto>> findAll() {

        List<SuperMarketDto> Supermarket_dtos = supermarketMapper.mapToDto(supermarketService.getAllSuperMarkets());

        return new ResponseEntity<List<SuperMarketDto>>(Supermarket_dtos, HttpStatus.OK);
    }

    @RequestMapping(value = "/supermarkets", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Supermarket> createSupermarket(
            @Valid
            @RequestParam(value = "supermarket_json", required = true) String marketJson,

            @RequestParam(value = "image") MultipartFile file) throws IOException {
        String fileName = fileStorageService.storeFile(file);
        Supermarket supermarket = objectMapper.readValue(marketJson, Supermarket.class);

        supermarket.setImage(fileName);
        supermarketService.createSuperMarket(supermarket);

        return new ResponseEntity<Supermarket>(supermarket, HttpStatus.CREATED);

    }

    @DeleteMapping("supermarkets/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity deleteSupermarket(@PathVariable Long id) throws SupermarketNotFoundException {
        supermarketService.deleteSuperMarketByID(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


    @RequestMapping(value = "/supermarkets/{id}", method = RequestMethod.PUT, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<SuperMarketDto> updateSupermarket(
            @Valid
            @RequestParam(value = "supermarket_json", required = true) String marketJson,

            @RequestParam(value = "image") MultipartFile file,
            @PathVariable Long id

    ) throws IOException, SupermarketNotFoundException {
        String fileName = fileStorageService.storeFile(file);
        SuperMarketDto superMarketDto = objectMapper.readValue(marketJson, SuperMarketDto.class);
        superMarketDto.setImage(fileName);
        superMarketDto.setId(id);
        supermarketService.editSuperMarket(superMarketDto, id);

        return new ResponseEntity<>(superMarketDto, HttpStatus.CREATED);

    }


    @RequestMapping(value = "/supermarkets/activate/{id}", method = RequestMethod.PATCH, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)

    public ResponseEntity<Supermarket> activate(@PathVariable Long id,
                                                   @RequestParam(value = "active", required = true) boolean activate


    ) throws SupermarketNotFoundException {

        Supermarket supermarket =supermarketService.activate_deactivate(id, activate);

        return new ResponseEntity<>(supermarket,HttpStatus.CREATED);

    }


}
