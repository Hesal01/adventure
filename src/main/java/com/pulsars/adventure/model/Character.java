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
    @Column(name = "character_id")
    private Long id;

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

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "character", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<InventoryItem> items;

    @ManyToOne
    @JoinColumn(name = "current_location_id", nullable = false)
    private Location currentLocation;

    public boolean isAlive() {
        return health > 0;
    }

    public void setHealthMinZero(Long health) {
        this.health = health;
    }

}
