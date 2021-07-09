package com.supermarket.supermarket.mapper;

import com.supermarket.supermarket.dto.SuperMarketDto;
import com.supermarket.supermarket.entity.Supermarket;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface SupermarketMapper {

        @Mapping(source = "id", target = "id")
    @Mapping(source = "ar_name", target = "ar_name")
    SuperMarketDto mapToDto(Supermarket t);

    List<SuperMarketDto> mapToDto(List<Supermarket> t);

        @Mapping(source = "id", target = "id")
    @Mapping(source = "ar_name", target = "ar_name")
    Supermarket mapToEntity(SuperMarketDto dto);

//    Supermarket mapToUpdate (SuperMarketDto dto ,@MappingTarget Supermarket t);

}
