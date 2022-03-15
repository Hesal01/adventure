package com.pulsars.adventure.service;

import com.pulsars.adventure.model.Enemy;
import com.pulsars.adventure.model.Item;
import com.pulsars.adventure.repository.EnemyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class EnemyService {

    private final int MAXIMUM_POSSIBLE_DROP = 10000;

    @Autowired
    private EnemyRepository enemyRepository;

    @Autowired
    private LocationService locationService;

    static Random random = new Random();

    public Iterable<Enemy> getEnemies() {
        return enemyRepository.findAll();
    }

    public Enemy getEnemy(Long id) {
        return enemyRepository.findById(id).get();
    }

    public Iterable<Enemy> getEnemiesOfLocation(Long locationId) {
        return locationService.getLocation(locationId).get().getEnemyPops();
        //return locationService.getLocationAndEnemyPops(locationId).getEnemyPops();
    }

    public Iterable<Enemy> getEnemyPopsOfLocation(Long locationId) {
        List<Enemy> enemies = new ArrayList<>();
        Iterable<Enemy> enemiesOfLocation = getEnemiesOfLocation(locationId);
        enemiesOfLocation.forEach(
                enemy -> {
                    int randomNumberEnemies = random.nextInt(MAXIMUM_POSSIBLE_DROP);
                    if (randomNumberEnemies <= enemy.getPopPerTenThousand()) {
                        enemies.add(enemy);
                    }
                }
        );
        return enemies;
    }

    public Iterable<Item> getCollectedEnemyDrops(Long enemyId) {
        List<Item> items = new ArrayList<>();
        Enemy enemy = getEnemy(enemyId);
        enemy.getEnemyDrops().forEach(
                item -> {
                    int randomNumberEnemies = random.nextInt(MAXIMUM_POSSIBLE_DROP);
                    if (randomNumberEnemies <= item.getDropPerTenThousand()) {
                        items.add(item);
                    }
                }
        );
        return items;
    }


}
