package items;

import jakarta.persistence.Embeddable;

@Embeddable
public class GemSlot {

    private String color;
    private Gem gem;

    public GemSlot(String color) {
        this.color = color;
        this.gem = null;
    }

    public GemSlot() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Gem getGem() {
        return gem;
    }

    public void setGem(Gem gem) {
        this.gem = gem;
    }

}
