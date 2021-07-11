package com.supermarket.supermarket.mapper;

import com.supermarket.supermarket.dto.SuperMarketDto;
import com.supermarket.supermarket.entity.Supermarket;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface SupermarketMapper {


    SuperMarketDto mapToDto(Supermarket t);

    List<SuperMarketDto> mapToDto(List<Supermarket> t);

    Supermarket mapToEntity(SuperMarketDto dto);



}
