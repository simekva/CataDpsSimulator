package items;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Item {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "item")
    private Collection<GemSlot> gemSlots;

    @OneToMany(mappedBy = "item")
    private Collection<Stat> stats;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int itemLevel;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ItemSlotEnum itemSlot;
}
