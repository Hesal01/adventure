package com.pulsars.adventure.rest.controller;

import com.pulsars.adventure.rest.dto.Character;
import com.pulsars.adventure.rest.mapper.CharacterMapper;
import com.pulsars.adventure.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @Autowired
    private CharacterMapper characterMapper;

    @GetMapping("/character/{userId}/{characterName}")
    public ResponseEntity<Character> getCharacter(@PathVariable Long userId, @PathVariable String characterName){
        return ResponseEntity.ok().body(characterMapper.map(characterService.getCharacterByUserIdAndName(userId, characterName)));
    }

}
