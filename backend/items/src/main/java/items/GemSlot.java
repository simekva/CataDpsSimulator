package items;

import items.Enums.GemSlotColorEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class GemSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id", foreignKey = @ForeignKey(name = "fk_stat_item"))
    private Item item;

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