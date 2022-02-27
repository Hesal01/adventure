package com.pulsars.adventure.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "characters")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "health")
    private Long health;

    @Column(name = "maxHealth")
    private Long maxHealth;

    @Column(name = "strength")
    private Long strength;

    @Column(name = "defense")
    private Long defense;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="inventories",
    joinColumns = {@JoinColumn(name = "character_id")},
    inverseJoinColumns = {@JoinColumn(name = "item_id")})
    private List<Item> items;
}
