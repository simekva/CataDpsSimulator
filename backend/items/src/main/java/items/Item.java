package items;

import java.util.Collection;

import items.Enums.ItemSlotEnum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Item {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "item_id")
    private Collection<GemSlot> gemSlots;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "item_id")
    private Collection<Stat> stats;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int itemLevel;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ItemSlotEnum itemSlot;

    public Item() {}

    public Item(String name, int itemLevel, ItemSlotEnum itemSlot, Collection<GemSlot> gemSlots, Collection<Stat> stats) {

        this.name = name;
        this.itemLevel = itemLevel;
        this.itemSlot = itemSlot;

        this.gemSlots = gemSlots;

        this.stats = stats;
    }

}
