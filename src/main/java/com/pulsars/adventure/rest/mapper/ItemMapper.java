package com.pulsars.adventure.rest.mapper;

import com.pulsars.adventure.rest.dto.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    Item map(com.pulsars.adventure.model.Item character);

}
