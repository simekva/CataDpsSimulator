package api.dtos;

import items.Enums.GemSlotColorEnum;

public class GemSlotInput {
    
    private GemSlotColorEnum color;

    public GemSlotColorEnum getColor() {
        return this.color;
    }

    public void setColor(GemSlotColorEnum color) {
        this.color = color;
    }
}
