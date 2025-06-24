package items;

import items.Enums.GemSlotColorEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class GemSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private GemSlotColorEnum color;

    public GemSlot() {}

    public GemSlot(GemSlotColorEnum color) {
        this.color = color;
    }

    public GemSlotColorEnum getColor() {
        return this.color;
    }
}