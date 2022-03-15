package com.pulsars.adventure.rest.mapper;

import com.pulsars.adventure.model.InventoryItem;
import com.pulsars.adventure.model.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InventoryItemToItemMapper {

    @Mapping(target = "title", source = "item.title")
    @Mapping(target = "rarity", source = "item.rarity")
    @Mapping(target = "amount", source = "amount")
    com.pulsars.adventure.rest.dto.Item map(InventoryItem inventoryItem);

}
