package com.pulsars.adventure.repository;

import com.pulsars.adventure.model.Area;
import com.pulsars.adventure.model.InventoryItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryItemRepository extends CrudRepository<InventoryItem, Long> {
}
