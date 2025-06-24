package characterstatcalc.Warrior;

import characterstatcalc.WowClass;
import characterstatcalc.Stats.CompleteStats;
import characterstatcalc.Stats.PrimaryStats;
import characterstatcalc.Stats.SecondaryStats;

public class WarriorClass implements WowClass {

    private CompleteStats completeBaseStats;

    private CompleteStats stats;

    public WarriorClass(PrimaryStats pStats, SecondaryStats sStats, CompleteStats baseStats) {
        this.completeBaseStats = baseStats;
        this.setBaseStats(baseStats);
        this.stats = calculateCompleteStats(pStats, sStats, baseStats);
    }

    public WarriorClass() {

    }

    @Override
    public void setBaseStats(CompleteStats baseStats) {
        this.completeBaseStats = baseStats;
    }

    public CompleteStats getBaseStats() {
        return this.completeBaseStats;
    }

    public void setStats(CompleteStats stats) {
        this.stats = stats;
    }

    @Override
    public CompleteStats getCompleteStats() {
        return this.stats;
    }

    private CompleteStats calculateCompleteStats(PrimaryStats pStats, SecondaryStats sStats, CompleteStats baseStats) {
        int attackPower = calculateAttackPower(pStats, baseStats);
        double haste = calculateHaste(sStats, baseStats);
        double weaponSpeed = calculateWeaponSpeed(sStats, haste, baseStats);
        double weaponMaxDamage = calculateMaxWeaponDamage(sStats, attackPower, weaponSpeed, baseStats);
        double weaponMinDamage = calculateMinWeaponDamage(sStats, attackPower, weaponSpeed, baseStats);

        sStats.setWeaponSpeed(weaponSpeed);
        sStats.setWeaponMinDamage(weaponMinDamage);
        sStats.setWeaponMaxDamage(weaponMaxDamage);

        double hitChance = calculateHitChance(sStats);
        double expertiseChance = calculateExpertiseChance(sStats);

        double critChance = calculateCritChance(pStats, sStats, baseStats);
        double masteryChance = calculateMasteryChance(sStats, baseStats);
        double dodgeChance = calculateDodgeChance(sStats, baseStats);
        double parryChance = calculateParryChance(pStats, sStats, baseStats);
        int armor = calculateArmor(sStats, baseStats);

        CompleteStats completeStats = new CompleteStats(pStats, sStats, attackPower, 0, hitChance, expertiseChance,
                critChance, masteryChance,
                dodgeChance, parryChance, baseStats.getBlockChance(), armor);

        return completeStats;
    }

    // --- Helper Functions ---

    private int calculateAttackPower(PrimaryStats pStats, CompleteStats baseStats) {
        int allStrength = this.completeBaseStats.getPrimaryStats().getStrength() + pStats.getStrength();
        return allStrength * 2 + baseStats.getAttackPower();
    }

    private double calculateHaste(SecondaryStats sStats, CompleteStats baseStats) {
        double hasteRating = baseStats.getSecondaryStats().getHasteRating() + sStats.getHasteRating();
        return (hasteRating / 128.057) / 100.0; // decimal for multiplying
    }

    private double calculateWeaponSpeed(SecondaryStats sStats, double haste, CompleteStats baseStats) {
        double baseSpeed = baseStats.getSecondaryStats().getWeaponSpeed() + sStats.getWeaponSpeed();
        double speed = baseSpeed * (1 - haste);
        return speed;
    }

    private double calculateCritChance(PrimaryStats pStats, SecondaryStats sStats, CompleteStats baseStats) {
        double critRating = baseStats.getSecondaryStats().getCritRating() + sStats.getCritRating();
        double critFromRating = critRating / 179.28;

        double agility = baseStats.getPrimaryStats().getAgility() + pStats.getAgility();
        double critFromAgility = agility / 324.85;
        return critFromRating + critFromAgility + baseStats.getCritChance();
    }

    private double calculateHitChance(SecondaryStats sStats) {
        return sStats.getHitRating() / 120.125;
    }

    private double calculateExpertiseChance(SecondaryStats sStats) {
        int expertisePoints = (int) Math.floor(sStats.getExpertiseRating() / 30.0272);
        return expertisePoints * 0.25;
    }

    private double calculateMasteryChance(SecondaryStats sStats, CompleteStats baseStats) {
        double masteryRating = baseStats.getSecondaryStats().getMasteryRating() + sStats.getMasteryRating();
        double masteryPoints = Math.floor(masteryRating / 179.28);
        return Math.floor(masteryPoints * 2.2) + baseStats.getMasteryChance(); // 2.2% bonus per point
    }

    private double calculateDodgeChance(SecondaryStats sStats, CompleteStats baseStats) {
        double dodgeRating = baseStats.getSecondaryStats().getDodgeRating() + sStats.getDodgeRating();
        return dodgeRating / 176.72 + baseStats.getDodgeChance();
    }

    private double calculateParryChance(PrimaryStats pStats, SecondaryStats sStats, CompleteStats baseStats) {
        double parryRating = baseStats.getSecondaryStats().getParryRating() + sStats.getParryRating();
        double allStrength = baseStats.getPrimaryStats().getStrength() + pStats.getStrength();
        parryRating += 0.27 * allStrength;
        return parryRating / 176.72 + baseStats.getParryChance();
    }

    private int calculateArmor(SecondaryStats sStats, CompleteStats baseStats) {
        return baseStats.getSecondaryStats().getArmor() + sStats.getArmor();
    }

    private double calculateMinWeaponDamage(SecondaryStats sStats, int attackPower, double weaponSpeed,
            CompleteStats baseStats) {
        double weaponMinDamage = baseStats.getSecondaryStats().getWeaponMinDamage() + sStats.getWeaponMinDamage();
        return (weaponMinDamage) + (attackPower / 14.0 * weaponSpeed);
    }

    private double calculateMaxWeaponDamage(SecondaryStats sStats, int attackPower, double weaponSpeed,
            CompleteStats baseStats) {
        double weaponMaxDamage = baseStats.getSecondaryStats().getWeaponMaxDamage() + sStats.getWeaponMaxDamage();
        return (weaponMaxDamage) + (attackPower / 14.0 * weaponSpeed);
    }

    public static void main(String[] args) {
        PrimaryStats pStats = new PrimaryStats(7377, 20, 7700, 20, 22);
        SecondaryStats sStats = new SecondaryStats(961, 692, 2584, 240, 1412, 4058, 2704, 3.6, 0, 0, 23215);

        PrimaryStats basePrimaryStats = new PrimaryStats(189, 143, 173, 37, 63);
        SecondaryStats baseSecondaryStats = new SecondaryStats(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        CompleteStats baseStats = new CompleteStats(basePrimaryStats, baseSecondaryStats, 613, 0, 0, 0, 0.5, 17,
                5, 5, 5, 0);

        WarriorClass warrior = new WarriorClass(pStats, sStats, baseStats);
        System.out.println("Warrior Class Stats: " + warrior.getCompleteStats().toString());
    }
}
