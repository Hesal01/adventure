package com.pulsars.adventure.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name = "checkpoint")
    private Boolean checkpoint;

    @Column(name = "next_location_main")
    private Long nextLocationMain;

    @Column(name = "next_location_secondary_1")
    private Long nextLocationSecondary1;

    @Column(name = "next_location_secondary_2")
    private Long nextLocationSecondary2;

    @Column(name = "next_location_secondary_3")
    private Long nextLocationSecondary3;

    @Column(name = "next_location_secondary_4")
    private Long nextLocationSecondary4;

    @Column(name = "next_location_secondary_5")
    private Long nextLocationSecondary5;

    @ManyToOne
    @JoinColumn(name = "area_id", nullable = false)
    private Area area;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="drops",
            joinColumns = {@JoinColumn(name = "location_id")},
            inverseJoinColumns = {@JoinColumn(name = "item_id")})
    private List<Item> drops;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="enemy_pops",
            joinColumns = {@JoinColumn(name = "location_id")},
            inverseJoinColumns = {@JoinColumn(name = "enemy_id")})
    private List<Enemy> enemyPops;

}
