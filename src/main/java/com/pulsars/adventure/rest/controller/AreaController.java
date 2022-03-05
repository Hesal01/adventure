package com.pulsars.adventure.rest.controller;

import com.pulsars.adventure.rest.dto.Area;
import com.pulsars.adventure.rest.dto.Character;
import com.pulsars.adventure.rest.mapper.AreaMapper;
import com.pulsars.adventure.rest.mapper.CharacterMapper;
import com.pulsars.adventure.service.AreaService;
import com.pulsars.adventure.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AreaController {

    @Autowired
    private AreaService areaService;

    @Autowired
    private AreaMapper areaMapper;

    @Secured("ADMIN")
    @GetMapping("/area/{id}")
    public ResponseEntity<Area> getCharacter(@PathVariable Long id){
        return ResponseEntity.ok().body(areaMapper.map(areaService.getArea(id).get()));
    }

}