package com.pulsars.adventure.service;

import com.pulsars.adventure.model.Character;
import com.pulsars.adventure.model.Enemy;
import com.pulsars.adventure.model.Location;
import com.pulsars.adventure.service.util.BattleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgressionService {

    @Autowired
    private CharacterService characterService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private EnemyService enemyService;

    @Autowired
    private BattleUtil battleUtil;

    public Character startProgression(String characterName) {
        Character character = characterService.getCharacterByName(characterName);
        goToNextCheckPoint(character.getCurrentLocation(), character);
        if(!character.isAlive()){
            character.setHealthMinZero(character.getMaxHealth());
            Long startLocationId = character.getCurrentLocation().getArea().getStartLocationId();
            character.setCurrentLocation(locationService.getLocation(startLocationId).get());
        }
        return characterService.save(character);
    }

    public void goToNextCheckPoint(Location currentLocation, Character character) {
        if (currentLocation.getNextLocationMain() == null) {
            return;
        }
        currentLocation = locationService.getLocation(currentLocation.getNextLocationMain()).get();//TODO: gérer si pas de next
        character.setCurrentLocation(currentLocation);
        List<Enemy> enemyPops = (List<Enemy>) enemyService.getEnemyPopsOfLocation(currentLocation.getId());
        enemyPops.forEach(
                enemy -> {
                    battleUtil.battle(character, enemy);
                    if (!character.isAlive()) {
                        return;
                    }
                }
        );
        if (character.isAlive()) {
            goToNextCheckPoint(currentLocation, character);
        }
    }

    public Character returnHome(String characterName) {
        Character character = characterService.getCharacterByName(characterName);
        Long startLocationId = character.getCurrentLocation().getArea().getStartLocationId();
        Location location = locationService.getLocation(startLocationId).get();
        character.setCurrentLocation(location);

        return characterService.save(character);
    }
}
