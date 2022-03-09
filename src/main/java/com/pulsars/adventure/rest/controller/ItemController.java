package com.pulsars.adventure.rest.controller;

import com.pulsars.adventure.model.Item;
import com.pulsars.adventure.rest.mapper.ItemMapper;
import com.pulsars.adventure.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemMapper itemMapper;

    @PreAuthorize("@authenticationService.isAdmin(#userName)")
    @GetMapping("/admin/items")
    public Iterable<Item> getItems(){
        return itemMapper.map(itemService.getItems());
    }

    @GetMapping("/items/{locationId}")
    public Iterable<Item> getItemsOfLocation(@PathVariable Long locationId){
        return itemMapper.map(itemService.getDropsOfLocation(locationId));
    }
}
