package com.pulsars.adventure.rest.controller;

import com.pulsars.adventure.rest.dto.Character;
import com.pulsars.adventure.rest.mapper.CharacterMapper;
import com.pulsars.adventure.service.ProgressionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProgressionController {

    @Autowired
    private ProgressionService progressionService;

    @Autowired
    private CharacterMapper characterMapper;

    @PreAuthorize("@authenticationService.hasAccess(#userName)")
    @GetMapping("startprogression/{userName}/{characterName}")
    public ResponseEntity<Character> startProgression(@PathVariable String userName, @PathVariable String characterName){
        return ResponseEntity.ok().body(characterMapper.map(progressionService.startProgression(characterName)));
    }

    @PreAuthorize("@authenticationService.hasAccess(#userName)")
    @GetMapping("returnhome/{userName}/{characterName}")
    public ResponseEntity<Character> returnHome(@PathVariable String userName, @PathVariable String characterName){
        return ResponseEntity.ok().body(characterMapper.map(progressionService.returnHome(characterName)));
    }

}
