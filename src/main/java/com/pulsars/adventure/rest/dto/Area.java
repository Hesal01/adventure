package com.pulsars.adventure.rest.dto;

import lombok.Data;

import java.util.List;

@Data
public class Area {

    private String name;

    private List<Location> locations;

}
