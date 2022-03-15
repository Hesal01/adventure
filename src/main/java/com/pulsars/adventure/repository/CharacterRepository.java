package com.pulsars.adventure.repository;

import com.pulsars.adventure.model.Character;
import com.pulsars.adventure.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends CrudRepository<Character, Long> {

    @Query("select c from Character c join fetch c.items i join fetch i.item it where c.user.id = ?1 ")
    Character getCharacterByUserId(Long userId);

    @Query("select c from Character c where c.id = ?1 ")
    Character getCharacterWithItems(Long characterId);
}
