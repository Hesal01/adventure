package com.pulsars.adventure.rest.mapper;

import com.pulsars.adventure.rest.dto.Area;
import com.pulsars.adventure.rest.dto.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AreaMapper {

    Area map(com.pulsars.adventure.model.Area area);

}
