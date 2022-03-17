package com.pulsars.adventure.rest.dto;

import com.pulsars.adventure.model.User;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class Character {

    private String name;

    private Long health;

    private Long maxHealth;

    private Long strength;

    private Long defense;

    private List<Item> items;

    private Location currentLocation;

}
