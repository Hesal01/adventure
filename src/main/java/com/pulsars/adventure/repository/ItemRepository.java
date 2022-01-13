package com.pulsars.adventure.repository;

import com.pulsars.adventure.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

}
