package simulator.Warrior;

import simulator.WowClass;
import simulator.Stats.CompleteStats;
import simulator.Stats.PrimaryStats;
import simulator.Stats.SecondaryStats;

public class WarriorClass implements WowClass {

    private PrimaryStats basePrimaryStats = new PrimaryStats(189, 123, 37, 173, 0);
    private SecondaryStats baseSecondaryStats = new SecondaryStats(
            0, 0, 89.64, 0, 8, 0, 0, 0, 833.6, 883.6, 0);

    private CompleteStats stats;

    public WarriorClass(PrimaryStats pStats, SecondaryStats sStats) {
        this.stats = calculateCompleteStats(pStats, sStats);
    }

    @Override
    public CompleteStats getCompleteStats() {
        return this.stats;
    }

    private CompleteStats calculateCompleteStats(PrimaryStats pStats, SecondaryStats sStats) {
        int attackPower = calculateAttackPower(pStats);
        double haste = calculateHaste(sStats);
        double weaponSpeed = calculateWeaponSpeed(sStats.getWeaponSpeed(), haste);
        double weaponMaxDamage = calculateMaxWeaponDamage(sStats, attackPower);
        double weaponMinDamage = calculateMinWeaponDamage(sStats, attackPower);
        double critChance = calculateCritChance(pStats, sStats);
        double masteryChance = calculateMasteryChance(sStats);
        double dodgeChance = calculateDodgeChance(sStats);
        double parryChance = calculateParryChance(pStats, sStats);
        int armor = calculateArmor(sStats);

        return new CompleteStats(
                pStats, sStats, attackPower, 0,
                critChance, masteryChance,
                weaponMaxDamage, weaponMinDamage,
                weaponSpeed, dodgeChance, parryChance, armor);
    }

    // --- Helper Functions ---

    private int calculateAttackPower(PrimaryStats pStats) {
        int allStrength = basePrimaryStats.getStrength() + pStats.getStrength();
        return allStrength * 2;
    }

    private double calculateHaste(SecondaryStats sStats) {
        double hasteRating = baseSecondaryStats.getHasteRating() + sStats.getHasteRating();
        return (hasteRating / 128.057) / 100.0; // decimal for multiplying
    }

    private double calculateWeaponSpeed(double baseSpeed, double haste) {
        return baseSpeed / (1.0 + haste);
    }

    private double calculateCritChance(PrimaryStats pStats, SecondaryStats sStats) {
        double critRating = baseSecondaryStats.getCritRating() + sStats.getCritRating();
        double agility = basePrimaryStats.getAgility() + pStats.getAgility();
        double critFromRating = critRating / 179.28;
        double critFromAgility = agility / 242.0;
        return critFromRating + critFromAgility;
    }

    private double calculateMasteryChance(SecondaryStats sStats) {
        double masteryRating = sStats.getMasteryRating();
        double masteryPoints = Math.floor(masteryRating / 179.28) + 8; // 8 base points
        return masteryPoints * 2.2; // 2.2% bonus per point
    }

    private double calculateDodgeChance(SecondaryStats sStats) {
        double dodgeRating = baseSecondaryStats.getDodgeRating() + sStats.getDodgeRating();
        return dodgeRating / 176.72;
    }

    private double calculateParryChance(PrimaryStats pStats, SecondaryStats sStats) {
        double parryRating = baseSecondaryStats.getParryRating() + sStats.getParryRating();
        double allStrength = basePrimaryStats.getStrength() + pStats.getStrength();
        parryRating += 0.27 * allStrength;
        return parryRating / 176.72;
    }

    private int calculateArmor(SecondaryStats sStats) {
        return baseSecondaryStats.getArmor() + sStats.getArmor();
    }

    private double calculateMinWeaponDamage(SecondaryStats sStats, int attackPower) {
        double weaponMinDamage = sStats.getWeaponMinDamage();
        return (weaponMinDamage) + (attackPower / 14.0 * 3.6);
    }

    private double calculateMaxWeaponDamage(SecondaryStats sStats, int attackPower) {
        double weaponMaxDamage = sStats.getWeaponMaxDamage();
        return (weaponMaxDamage) + (attackPower / 14.0 * 3.6);
    }

    // Main method for quick testing
    public static void main(String[] args) {
        PrimaryStats pStats = new PrimaryStats(7377, 20, 7700, 20, 22);
        SecondaryStats secondaryStats = new SecondaryStats(961, 692, 2584, 240, 1412, 4058, 2704, 3.6, 0, 0, 23215);
        WarriorClass warrior = new WarriorClass(pStats, secondaryStats);
        CompleteStats completeStats = warrior.getCompleteStats();
        System.out.println(completeStats.toString());
    }
}
