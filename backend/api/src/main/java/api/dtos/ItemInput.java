package api.dtos;

import java.util.Collection;

import items.Enums.ItemSlotEnum;

public class ItemInput {

    private long id;
    private String name;
    private int itemLevel;
    private ItemSlotEnum itemSlot;
    private Collection<GemSlotInput> gemSlots;
    private Collection<StatInput> stats;
    private boolean isTwoHand;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getItemLevel() {
        return this.itemLevel;
    }

    public void setItemLevel(int itemLevel) {
        this.itemLevel = itemLevel;
    }

    public ItemSlotEnum getItemSlot() {
        return this.itemSlot;
    }

    public void setItemSlot(ItemSlotEnum itemSlot) {
        this.itemSlot = itemSlot;
    }

    public Collection<GemSlotInput> getGemSlots() {
        return this.gemSlots;
    }

    public void setGemSlots(Collection<GemSlotInput> gemSlots) {
        this.gemSlots = gemSlots;
    }

    public Collection<StatInput> getStats() {
        return this.stats;
    }

    public void setStats(Collection<StatInput> stats) {
        this.stats = stats;
    }

    public boolean getIsTwoHand() {
        return this.isTwoHand;
    }

    public void setIsTwoHand(boolean isTwoHand) {
        this.isTwoHand = isTwoHand;
    }
}
