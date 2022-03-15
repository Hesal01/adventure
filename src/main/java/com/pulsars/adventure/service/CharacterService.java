package com.pulsars.adventure.service;

import com.pulsars.adventure.model.Character;
import com.pulsars.adventure.repository.CharacterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    public Character getCharacter(Long id){
        return characterRepository.findById(id).get();
    }

    public Character getCharacterByUserId(Long userId){
        return characterRepository.getCharacterByUserId(userId);
    }

    public Character getCharacterWithItems(Long characterId){
        return characterRepository.getCharacterWithItems(characterId);
    }

    public Character save(Character character) {
        return this.characterRepository.save(character);
    }
}
