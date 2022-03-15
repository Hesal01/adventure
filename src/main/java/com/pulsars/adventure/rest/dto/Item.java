package com.pulsars.adventure.rest.dto;

import lombok.Data;

@Data
public class Item {

    private String title;

    private Rarity rarity;

    private Long amount;

}
