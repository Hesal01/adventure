package com.pulsars.adventure.repository;

import com.pulsars.adventure.model.Character;
import com.pulsars.adventure.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends CrudRepository<User, Long> {

    @Query("select c from Character c where c.user.id = ?1 ")
    Character getCharacterByUserId(Long userId);
}
