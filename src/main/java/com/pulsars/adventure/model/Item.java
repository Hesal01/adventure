package com.pulsars.adventure.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name ="drop_per_ten_thousand")
    private Long dropPerTenThousand;

    @ManyToOne
    @JoinColumn(name = "rarity_id", nullable = false)
    private Rarity rarity;

    @OneToMany(mappedBy = "item", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<InventoryItem> characters;

}
