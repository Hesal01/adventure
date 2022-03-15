package com.pulsars.adventure.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class InventoryItemId implements Serializable {

    @Column(name = "character_id")
    private Long characterId;

    @Column(name = "item_id")
    private Long itemId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        InventoryItemId that = (InventoryItemId) o;
        return Objects.equals(characterId, that.characterId) &&
                Objects.equals(itemId, that.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(characterId, itemId);
    }

}
