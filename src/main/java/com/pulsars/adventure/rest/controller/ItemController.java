package com.pulsars.adventure.rest.controller;

import com.pulsars.adventure.model.Item;
import com.pulsars.adventure.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public Iterable<Item> getItems(){
        return itemService.getItems();
    }
}
