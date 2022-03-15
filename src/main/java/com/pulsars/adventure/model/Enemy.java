package com.pulsars.adventure.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "enemies")
public class Enemy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "health")
    private Long health;

    @Column(name = "maxHealth")
    private Long maxHealth;

    @Column(name = "strength")
    private Long strength;

    @Column(name = "defense")
    private Long defense;

    @Column(name = "agility")
    private Long agility;

    @Column(name ="pop_per_ten_thousand")
    private Long popPerTenThousand;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="enemy_drops",
            joinColumns = {@JoinColumn(name = "enemy_id")},
            inverseJoinColumns = {@JoinColumn(name = "item_id")})
    private List<Item> enemyDrops;

}
