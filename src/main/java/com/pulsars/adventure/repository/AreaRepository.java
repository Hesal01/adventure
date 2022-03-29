package com.pulsars.adventure.repository;

import com.pulsars.adventure.model.Area;
import com.pulsars.adventure.model.Character;
import com.pulsars.adventure.model.Location;
import com.pulsars.adventure.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaRepository extends CrudRepository<Area, Long> {

}
