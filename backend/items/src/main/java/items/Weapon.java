package items;

import java.util.Collection;

import items.Enums.ItemSlotEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Weapon extends Item {

    @Column(nullable = false)
    private boolean isTwoHand = false;

    public Weapon() {
    }

    public Weapon(String name, int itemLevel, ItemSlotEnum itemSlot, Collection<GemSlot> gemSlots,
            Collection<Stat> stats, boolean isTwoHand) {
        super(name, itemLevel, itemSlot, gemSlots, stats);
        this.isTwoHand = isTwoHand;
    }

    public boolean getIsTwoHand() {
        return isTwoHand;
    }

    public void setIsTwoHand(boolean isTwoHand) {
        this.isTwoHand = isTwoHand;
    }
}
