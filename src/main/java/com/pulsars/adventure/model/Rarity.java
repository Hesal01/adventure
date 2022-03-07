package com.pulsars.adventure.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "rarities")
public class Rarity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "color")
    private String color;

    @OneToMany(mappedBy = "rarity", fetch = FetchType.LAZY)
    private List<Item> items;

}
