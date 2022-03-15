package com.pulsars.adventure.service;

import com.pulsars.adventure.model.Enemy;
import com.pulsars.adventure.model.Item;
import com.pulsars.adventure.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ItemService {

    private final int MAXIMUM_POSSIBLE_DROP = 10000;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private LocationService locationService;

    static Random random = new Random();

    public Iterable<Item> getItems(){
        return itemRepository.findAll();
    }

    public Iterable<Item> getItemsOfLocation(Long locationId){
        return locationService.getLocation(locationId).get().getDrops();
    }

    public Iterable<Item> getDropsOfLocation(Long locationId){
        List<Item> items = new ArrayList<>();
        Iterable<Item> itemsOfLocation = getItemsOfLocation(locationId);
        itemsOfLocation.forEach(
                i -> {
                    int randomNumberItems = random.nextInt(MAXIMUM_POSSIBLE_DROP);
                    if(randomNumberItems <= i.getDropPerTenThousand()){
                        items.add(i);
                    }
                }
        );
        return items;
    }

}
