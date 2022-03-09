package com.pulsars.adventure.service;

import com.pulsars.adventure.model.Item;
import com.pulsars.adventure.model.Location;
import com.pulsars.adventure.repository.ItemRepository;
import com.pulsars.adventure.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public Iterable<Location> getLocations(){
        return locationRepository.findAll();
    }

    public Optional<Location> getLocation(Long id){
        return locationRepository.findById(id);
    }

}
