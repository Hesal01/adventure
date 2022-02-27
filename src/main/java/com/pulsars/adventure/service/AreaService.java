package com.pulsars.adventure.service;

import com.pulsars.adventure.model.Area;
import com.pulsars.adventure.model.Character;
import com.pulsars.adventure.repository.AreaRepository;
import com.pulsars.adventure.repository.CharacterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class AreaService {

    @Autowired
    private AreaRepository areaRepository;

    public Optional<Area> getArea(Long id){
        return areaRepository.findById(id);
    }

}
