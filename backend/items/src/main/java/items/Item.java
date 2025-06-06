package items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.MapKeyEnumerated;
import jakarta.persistence.Transient;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int itemLevel;

    @Enumerated(EnumType.STRING)
    private ItemSlotEnum itemSlot;

    @Transient
    private int numberOfGemSlots;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "item_gem_slots", joinColumns = @JoinColumn(name = "item_id"))
    @AttributeOverrides({
            @AttributeOverride(name = "color", column = @Column(name = "gem_color"))
    })
    private List<GemSlot> gemSlots;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "item_stats", joinColumns = @jakarta.persistence.JoinColumn(name = "item_id"))
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "stat")
    @Column(name = "value")
    private Map<StatsEnum, Integer> stats = new HashMap<>();

    public Item(String name, int itemLevel, ItemSlotEnum itemSlot, List<String> colorsOnGemSlots,
            Map<StatsEnum, Integer> stats) {
        this.name = name;
        this.itemLevel = itemLevel;
        this.itemSlot = itemSlot;
        this.numberOfGemSlots = colorsOnGemSlots.size();
        gemSlots = new ArrayList<>(numberOfGemSlots);
        for (String color : colorsOnGemSlots) {
            gemSlots.add(new GemSlot(color));
        }
        this.stats = stats;
    }

    public Item() {
    }

    public void setGemOnSlot(int slotIndex, Gem gem) {
        if (slotIndex < 0 || slotIndex >= gemSlots.size()) {
            throw new IndexOutOfBoundsException("Invalid gem slot index: " + slotIndex);
        }
        gemSlots.get(slotIndex).setGem(gem);

        // Merge gem stats into item stats
        for (Map.Entry<StatsEnum, Integer> entry : gem.getStats().entrySet()) {
            this.stats.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getItemLevel() {
        return itemLevel;
    }

    public void setItemLevel(int itemLevel) {
        this.itemLevel = itemLevel;
    }

    public ItemSlotEnum getItemSlot() {
        return itemSlot;
    }

    public void setItemSlot(ItemSlotEnum itemSlot) {
        this.itemSlot = itemSlot;
    }

    public int getNumberOfGemSlots() {
        return numberOfGemSlots;
    }

    public void setNumberOfGemSlots(int numberOfGemSlots) {
        this.numberOfGemSlots = numberOfGemSlots;
    }

    public List<GemSlot> getGemSlots() {
        return gemSlots;
    }

    public void setGemSlots(List<GemSlot> gemSlots) {
        this.gemSlots = gemSlots;
    }

    public Map<StatsEnum, Integer> getStats() {
        return stats;
    }

    public void setStats(Map<StatsEnum, Integer> stats) {
        this.stats = stats;
    }

    public static void main(String[] args) {
        String name = "Colossal Dragonplate Helmet";
        int itemLevel = 410;
        ItemSlotEnum itemSlot = ItemSlotEnum.HEAD;

        List<String> colorsOnGemSlots = new ArrayList<String>();
        colorsOnGemSlots.add("META");
        colorsOnGemSlots.add("RED");

        HashMap<StatsEnum, Integer> stats = new HashMap<StatsEnum, Integer>();
        stats.put(StatsEnum.ARMOR, 3231);
        stats.put(StatsEnum.STRENGTH, 489);
        stats.put(StatsEnum.STAMINA, 824);
        stats.put(StatsEnum.CRITRATING, 331);
        stats.put(StatsEnum.EXPERTISERATING, 341);

        Item item = new Item(name, itemLevel, itemSlot, colorsOnGemSlots, stats);

        item.setGemOnSlot(0, new Gem("temp", "red", new HashMap<StatsEnum, Integer>() {
            {
                put(StatsEnum.STRENGTH, 20);
                put(StatsEnum.CRITRATING, 30);
            }
        }));

        System.out.println(item.stats);
    }
}
