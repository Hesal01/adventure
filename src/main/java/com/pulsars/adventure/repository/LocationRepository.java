package com.pulsars.adventure.repository;

import com.pulsars.adventure.model.Item;
import com.pulsars.adventure.model.Location;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {

    @Query("select l from Location l join fetch l.enemyPops where l.id =?1 ")
    public Location getLocationByIdAndEnemyPops(Long locationId);

    @Query("select l from Location l where l.area.id =?1")
    List<Location> getLocationsOfArea(Long areaId);

}
