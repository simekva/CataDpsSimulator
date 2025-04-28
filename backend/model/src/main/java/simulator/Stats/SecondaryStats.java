package simulator.Stats;

public class SecondaryStats {

    private double hitRating;
    private double expertiseRating;
    private double critRating;
    private double hasteRating;
    private double masteryRating;
    private double weaponMaxDamage;
    private double weaponMinDamage;
    private double weaponSpeed;

    private int armor;

    private double dodgeRating;
    private double parryRating;

    public SecondaryStats(double hitRating, double expertiseRating, double critRating, double hasteRating,
            double masteryRating, double weaponMaxDamage, double weaponMinDamage, double weaponSpeed,
            double dodgeRating,
            double parryRating, int armor) {
        this.hitRating = hitRating;
        this.expertiseRating = expertiseRating;
        this.critRating = critRating;
        this.hasteRating = hasteRating;
        this.masteryRating = masteryRating;
        this.weaponMaxDamage = weaponMaxDamage;
        this.weaponMinDamage = weaponMinDamage;
        this.weaponSpeed = weaponSpeed;
        this.dodgeRating = dodgeRating;
        this.parryRating = parryRating;
        this.armor = armor;
    }

    public double getHitRating() {
        return hitRating;
    }

    public double getExpertiseRating() {
        return expertiseRating;
    }

    public double getCritRating() {
        return critRating;
    }

    public double getHasteRating() {
        return hasteRating;
    }

    public double getMasteryRating() {
        return masteryRating;
    }

    public double getWeaponMaxDamage() {
        return weaponMaxDamage;
    }

    public double getWeaponMinDamage() {
        return weaponMinDamage;
    }

    public double getWeaponSpeed() {
        return weaponSpeed;
    }

    public double getDodgeRating() {
        return dodgeRating;
    }

    public double getParryRating() {
        return parryRating;
    }

    public int getArmor() {
        return armor;
    }
}
