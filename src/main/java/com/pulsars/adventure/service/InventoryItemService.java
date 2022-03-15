package com.pulsars.adventure.service;

import com.pulsars.adventure.model.Character;
import com.pulsars.adventure.model.InventoryItem;
import com.pulsars.adventure.repository.CharacterRepository;
import com.pulsars.adventure.repository.InventoryItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InventoryItemService {

    @Autowired
    private InventoryItemRepository inventoryItemRepository;

    public InventoryItem save(InventoryItem inventoryItem) {
        return this.inventoryItemRepository.save(inventoryItem);
    }

}
