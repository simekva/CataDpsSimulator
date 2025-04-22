package simulator.Stats;

import java.util.HashMap;

public class SecondaryStats {

    private HashMap<String, Double> stats;

    /**
     * 
     * @param hitRating
     * @param expertiseRating
     * @param critRating
     * @param hasteRating
     * @param masteryRating
     * @param armor
     * @param minWeaponDamage
     * @param maxWeaponDamage
     * @param weaponSpeed
     */
    public SecondaryStats(double hitRating, double expertiseRating, double critRating, double hasteRating,
            double masteryRating, double armor, double minWeaponDamage, double maxWeaponDamage, double weaponSpeed) {

        this.stats = new HashMap<>();

        this.stats.put("hitRating", hitRating);
        this.stats.put("expertiseRating", expertiseRating);
        this.stats.put("critRating", critRating);
        this.stats.put("hasteRating", hasteRating);
        this.stats.put("masteryRating", masteryRating);
        this.stats.put("armor", armor);
        this.stats.put("minWeaponDamage", minWeaponDamage);
        this.stats.put("maxWeaponDamage", maxWeaponDamage);
        this.stats.put("weaponSpeed", weaponSpeed);
    }

    /**
     * 
     * @param s hitRating/expertiseRating/critRating/hasteRating/masteryRating/armor/minWeaponDamage/maxWeaponDamage/weaponSpeed
     * @return
     */
    public double getStat(String s) {
        return this.stats.get(s);
    }
}
