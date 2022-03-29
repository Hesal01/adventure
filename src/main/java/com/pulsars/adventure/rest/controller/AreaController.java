package com.pulsars.adventure.rest.controller;

import com.pulsars.adventure.model.Character;
import com.pulsars.adventure.rest.dto.Area;
import com.pulsars.adventure.rest.dto.Location;
import com.pulsars.adventure.rest.mapper.AreaMapper;
import com.pulsars.adventure.rest.mapper.LocationMapper;
import com.pulsars.adventure.service.AreaService;
import com.pulsars.adventure.service.CharacterService;
import com.pulsars.adventure.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AreaController {

    @Autowired
    private AreaService areaService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private AreaMapper areaMapper;

    @Autowired
    private LocationMapper locationMapper;

    @PreAuthorize("@authenticationService.isAdmin(#userName)")
    @GetMapping("/admin/area/{id}")
    public ResponseEntity<Area> getCharacter(@PathVariable Long id){
        return ResponseEntity.ok().body(areaMapper.map(areaService.getArea(id).get()));
    }

    @PreAuthorize("@authenticationService.hasAccess(#userName)")
    @GetMapping("/area/locations/{userName}/{characterName}")
    public ResponseEntity<List<Location>> getLocationsOfCharacterArea(@PathVariable String userName,
                                                                      @PathVariable String characterName){
        return ResponseEntity.ok().body(locationMapper.map(locationService.getLocationsOfArea(characterName)));
    }

}