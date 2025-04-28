package simulator.Stats;

public class CompleteStats {
    private PrimaryStats primaryStats;
    private SecondaryStats secondaryStats;

    // To be calculated based on the primary and secondary stats
    private int attackPower;
    private int spellPower;
    private double critChance;
    private double masteryChance;
    private double weaponMaxDamage;
    private double weaponMinDamage;
    private double weaponSpeed;
    private double dodgeChance;
    private double parryChance;
    private double blockChance;

    private double armor;

    public CompleteStats(PrimaryStats pStats, SecondaryStats sStats, int attackPower, int spellPower, double critChance,
            double masteryChance, double weaponMaxDamage, double weaponMinDamage, double weaponSpeed,
            double dodgeChance, double parryChance, double armor) {
        this.primaryStats = pStats;
        this.secondaryStats = sStats;
        this.attackPower = attackPower;
        this.spellPower = spellPower;
        this.critChance = critChance;
        this.masteryChance = masteryChance;
        this.weaponMaxDamage = weaponMaxDamage;
        this.weaponMinDamage = weaponMinDamage;
        this.weaponSpeed = weaponSpeed;
        this.dodgeChance = dodgeChance;
        this.parryChance = parryChance;
        this.armor = armor;
    }

    public PrimaryStats getPrimaryStats() {
        return primaryStats;
    }

    public SecondaryStats getSecondaryStats() {
        return secondaryStats;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getSpellPower() {
        return spellPower;
    }

    public double getCritChance() {
        return critChance;
    }

    public double getMasteryChance() {
        return masteryChance;
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

    public double getDodgeChance() {
        return dodgeChance;
    }

    public double getParryChance() {
        return parryChance;
    }

    public double getBlockChance() {
        return blockChance;
    }

    public double getArmor() {
        return armor;
    }

    public String toString() {
        return "CompleteStats{" +
                ", attackPower=" + attackPower +
                ", spellPower=" + spellPower +
                ", critChance=" + critChance +
                ", masteryChance=" + masteryChance +
                ", weaponMaxDamage=" + weaponMaxDamage +
                ", weaponMinDamage=" + weaponMinDamage +
                ", weaponSpeed=" + weaponSpeed +
                ", dodgeChance=" + dodgeChance +
                ", parryChance=" + parryChance +
                ", blockChance=" + blockChance +
                ", armor=" + armor +
                '}';
    }
}
