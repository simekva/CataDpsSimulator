package items;

import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;

@Embeddable
public class Gem {

    private String name;
    private String color;

    // Stats are represented as a map where the key is the stat type and the value
    // is the amount
    @Transient
    private Map<StatsEnum, Integer> stats = new HashMap<StatsEnum, Integer>();

    public Gem(String name, String color, Map<StatsEnum, Integer> stats) {
        this.name = name;
        this.color = color;
        this.stats = stats;
    }

    public Gem() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Map<StatsEnum, Integer> getStats() {
        return stats;
    }

    public void setStats(Map<StatsEnum, Integer> stats) {
        this.stats = stats;
    }
}
