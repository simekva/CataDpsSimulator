package items;

import items.Enums.StatsEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Stat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private StatsEnum key;

    private int value;

    public Stat() {
    }

    public Stat(StatsEnum key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public StatsEnum getKey() {
        return this.key;
    }
}
