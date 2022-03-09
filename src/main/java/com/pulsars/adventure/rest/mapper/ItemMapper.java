package com.pulsars.adventure.rest.mapper;

import com.pulsars.adventure.model.Item;
import com.pulsars.adventure.rest.dto.Character;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    Item map(com.pulsars.adventure.model.Item item);

    Iterable<Item> map(Iterable<com.pulsars.adventure.model.Item> item);

}
