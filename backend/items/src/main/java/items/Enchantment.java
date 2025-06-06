package items;

import java.util.HashMap;
import java.util.Map;

public class Enchantment {

    private String name;

    // Stats are represented as a map where the key is the stat type and the value
    // is the amount
    private Map<StatsEnum, Integer> stats = new HashMap<StatsEnum, Integer>();

    // ItemSlotEnum represents the slot where the enchantment can be applied
    private ItemSlotEnum itemSlot;

    public Enchantment(String name, Map<StatsEnum, Integer> stats, ItemSlotEnum itemSlot) {
        this.name = name;
        this.stats = stats;
        this.itemSlot = itemSlot;
    }

    public Enchantment() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemSlotEnum getItemSlot() {
        return itemSlot;
    }

    public void setItemSlot(ItemSlotEnum itemSlot) {
        this.itemSlot = itemSlot;
    }

    public Map<StatsEnum, Integer> getStats() {
        return stats;
    }

    public void setStats(Map<StatsEnum, Integer> stats) {
        this.stats = stats;
    }
}
