package items;

public class StatsInput {
    private StatsEnum key;
    private Integer value;

    public StatsInput() {
    }

    public StatsEnum getKey() {
        return key;
    }

    public void setKey(StatsEnum key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
