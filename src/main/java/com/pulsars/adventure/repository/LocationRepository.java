package com.pulsars.adventure.repository;

import com.pulsars.adventure.model.Item;
import com.pulsars.adventure.model.Location;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {

    @Query("select l from Location l join fetch l.enemyPops where l.id =?1 ")
    public Location getLocationByIdAndEnemyPops(Long locationId);

}
