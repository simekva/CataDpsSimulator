package simulator.Stats;

import java.util.HashMap;

public class PrimaryStats {

    private HashMap<String, Double> stats;

    /**
     * 
     * @param strength
     * @param agility
     * @param intellect
     * @param stamina
     * @param spirit
     */
    public PrimaryStats(double strength, double agility, double intellect, double stamina, double spirit) {
        this.stats = new HashMap<>();

        this.stats.put("strength", strength);
        this.stats.put("agility", agility);
        this.stats.put("intellect", intellect);
        this.stats.put("stamina", stamina);
        this.stats.put("spirit", spirit);
    }

    /**
     * 
     * @param s strength/agility/intellect/stamina
     * @return
     */
    public double getStat(String s) {
        return this.stats.get(s);
    }
}
