package com.pulsars.adventure.rest.mapper;

import com.pulsars.adventure.rest.dto.Area;
import com.pulsars.adventure.rest.dto.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User map(com.pulsars.adventure.model.User user);
    com.pulsars.adventure.model.User map(User user);
    Iterable<com.pulsars.adventure.model.User> map(Iterable<User> user);
    Iterable<User> mapTo(Iterable<com.pulsars.adventure.model.User> user);

}
