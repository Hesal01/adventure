package com.pulsars.adventure.rest.mapper;

import com.pulsars.adventure.model.Item;
import com.pulsars.adventure.rest.dto.Rarity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RarityMapper {

    Rarity map(com.pulsars.adventure.model.Rarity rarity);

}
