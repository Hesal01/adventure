package com.pulsars.adventure.repository;

import com.pulsars.adventure.model.Item;
import com.pulsars.adventure.model.Location;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {

}
