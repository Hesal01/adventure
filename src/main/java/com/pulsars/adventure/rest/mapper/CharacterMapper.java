package com.pulsars.adventure.rest.mapper;

import com.pulsars.adventure.rest.dto.Character;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = InventoryItemToItemMapper.class)
public interface CharacterMapper {

    Character map(com.pulsars.adventure.model.Character character);

}
