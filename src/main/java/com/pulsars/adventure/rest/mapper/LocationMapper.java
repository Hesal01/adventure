package com.pulsars.adventure.rest.mapper;

import com.pulsars.adventure.rest.dto.Area;
import com.pulsars.adventure.rest.dto.Location;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocationMapper {

    Location map(com.pulsars.adventure.model.Location location);

    List<Location> map(List<com.pulsars.adventure.model.Location> location);

}
