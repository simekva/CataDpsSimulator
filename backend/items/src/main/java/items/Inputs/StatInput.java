package items.Inputs;

import items.Enums.StatsEnum;

public class StatInput {
    
    private StatsEnum key;
    private int value;

    public StatsEnum getKey() {
        return this.key;
    }

    public void setKey(StatsEnum e) {
        this.key = e;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int n) {
        this.value = n;
    }
}
