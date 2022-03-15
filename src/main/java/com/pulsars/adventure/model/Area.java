package com.pulsars.adventure.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "areas")
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="start_location")
    private Long startLocationId;

    @OneToMany(mappedBy = "area")
    private List<Location> locations;

}
