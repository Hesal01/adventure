package com.pulsars.adventure.service;

import com.pulsars.adventure.model.Item;
import com.pulsars.adventure.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Iterable<Item> getItems(){
        return itemRepository.findAll();
    }

}
