package com.pulsars.adventure.service.util;

import com.pulsars.adventure.model.*;
import com.pulsars.adventure.model.Character;
import com.pulsars.adventure.rest.mapper.InventoryItemToItemMapper;
import com.pulsars.adventure.service.EnemyService;
import com.pulsars.adventure.service.InventoryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BattleUtil {

    @Autowired
    private EnemyService enemyService;

    @Autowired
    private InventoryItemService inventoryItemService;

    @Autowired
    private InventoryItemToItemMapper inventoryItemToItemMapper;

    public void battle(Character character, Enemy enemy) {
        fight(character, enemy);
        if (character.isAlive()) {
            getDrop(character, enemy);
        }
    }

    private void getDrop(Character character, Enemy enemy) {
        Iterable<Item> collectedEnemyDrops = enemyService.getCollectedEnemyDrops(enemy.getId());
        collectedEnemyDrops.forEach(
                collectedDrop -> {
                    if (character.getItems().stream().anyMatch(
                            inventoryItem -> inventoryItem.getItem().getId() == collectedDrop.getId()
                    )) {
                        character.getItems().stream().filter(
                                inventoryItem -> inventoryItem.getItem().getId() == collectedDrop.getId()
                        ).findFirst().get().addToAmount();
                    } else {

                        character.getItems().add(addItemToInventory(character, collectedDrop));
                    }
                }
        );
    }

    private InventoryItem addItemToInventory(Character character, Item itemToAdd) {
        InventoryItem inventoryItem = InventoryItem.builder()
                .inventoryItemId(InventoryItemId.builder().itemId(itemToAdd.getId()).characterId(character.getId())
                        .build())
                .character(character)
                .item(itemToAdd)
                .amount(1)
                .build();

        return inventoryItemService.save(inventoryItem);
    }

    private void fight(Character character, Enemy enemy) {
        if (characterAttacksFirst(character, enemy)) {
            while (character.getHealth() > 0 || enemy.getHealth() > 0) {
                enemy.setHealth(enemy.getHealth() - character.getStrength());
                if (enemy.getHealth() <= 0) {
                    break;
                }
                character.setHealthMinZero(character.getHealth() - enemy.getStrength());
                if (character.getHealth() <= 0) {
                    break;
                }
            }
        } else {
            while (character.getHealth() > 0 || enemy.getHealth() > 0) {
                character.setHealthMinZero(character.getHealth() - enemy.getStrength());
                if (character.getHealth() <= 0) {
                    break;
                }
                enemy.setHealth(enemy.getHealth() - character.getStrength());
                if (enemy.getHealth() <= 0) {
                    break;
                }
            }
        }
        if (character.isAlive()) {
            getDrop(character, enemy);
        }
    }

    private boolean characterAttacksFirst(Character character, Enemy enemy) {
        return character.getAgility() > enemy.getAgility();
    }
}
