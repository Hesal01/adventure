package com.pulsars.adventure.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "inventories")
public class InventoryItem implements Serializable {

    @EmbeddedId
    private InventoryItemId inventoryItemId;

    @ManyToOne
    @MapsId("characterId")
    @JoinColumn(name = "character_id", referencedColumnName = "character_id")
    private Character character;

    @ManyToOne
    @MapsId("itemId")
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private Item item;

    @Column(name = "amount")
    private int amount;

    public void addToAmount(){
        amount++;
    }

}
