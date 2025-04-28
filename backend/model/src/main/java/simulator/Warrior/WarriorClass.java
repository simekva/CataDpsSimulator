package simulator.Warrior;

import simulator.WowClass;
import simulator.Stats.CompleteStats;
import simulator.Stats.PrimaryStats;
import simulator.Stats.SecondaryStats;

public class WarriorClass implements WowClass {

    // Base stats for level 85 warrior
    private PrimaryStats basePrimaryStats = new PrimaryStats(189, 123, 37, 173, 0);
    private SecondaryStats baseSecondaryStats = new SecondaryStats(0, 0, 89.64,
            0, 8, 0, 0, 0,
            833.6, 883.6, 0);

    private CompleteStats stats;

    public WarriorClass(PrimaryStats pStats, SecondaryStats sStats) {
        this.stats = this.calculateCompleteStats(pStats, sStats);
    }

    private CompleteStats calculateCompleteStats(PrimaryStats pStats, SecondaryStats sStats) {

        /////////////////////////
        /// AP = Strength * 2 ///
        /////////////////////////
        int allStrength = basePrimaryStats.getStrength() + pStats.getStrength();
        int attackPower = allStrength * 2;

        /////////////////////////////////////
        /// 128.057 haste = 1% faster speed. ///
        /// Haste / 128.057 / 100% = speed increase. ///
        /// Weapon speed / speed increase = new Weapon Speed ///
        //////////////////////////////////////////////////////////

        Double hasteRating = baseSecondaryStats.getHasteRating();
        hasteRating = hasteRating + sStats.getHasteRating();

        Double haste = (hasteRating / 128.057) / 100;
        Double weaponSpeed = sStats.getWeaponSpeed() / (1 + haste);

        /////////////////////////////////////////////////////
        /// wepDPS = minDamage + maxDamage / 2 / wepSpeed ///
        /// 14AP = +1 wepDPS ///
        /////////////////////////////////////////////////////
        Double weaponDPS = (sStats.getWeaponMinDamage() + sStats.getWeaponMaxDamage() / 2)
                / weaponSpeed;
        weaponDPS = weaponDPS + (attackPower / 14);

        Double critRating = baseSecondaryStats.getCritRating();
        critRating = critRating + sStats.getCritRating();

        Double critChance = ((critRating / 179.28))
                + (((basePrimaryStats.getAgility() + pStats.getAgility()) / 242));

        Double masteryRating = sStats.getMasteryRating();
        int masteryPoints = (int) Math.floor(masteryRating / 179.28) + 8;
        int masteryChance = (int) Math.ceil(masteryPoints * 2.2);

        Double dodgeRating = baseSecondaryStats.getDodgeRating() + sStats.getDodgeRating();
        Double dodgeChance = dodgeRating / 176.72;

        Double parryRating = baseSecondaryStats.getParryRating() + sStats.getParryRating();
        parryRating += 0.27 * allStrength;
        Double parryChance = parryRating / 176.72;

        int armor = baseSecondaryStats.getArmor() + sStats.getArmor();

        CompleteStats completeStats = new CompleteStats(pStats, sStats, attackPower, 0,
                critChance, masteryChance, sStats.getWeaponMaxDamage(), sStats.getWeaponMinDamage(),
                weaponSpeed, dodgeChance, parryChance, armor);

        return completeStats;
    }

    @Override
    public CompleteStats getCompleteStats() {
        return this.stats;
    }

    public static void main(String[] args) {
        PrimaryStats pStats = new PrimaryStats(7377, 20, 7700, 20, 22);
        SecondaryStats secondaryStats = new SecondaryStats(961, 692, 2584, 240, 1412, 4058, 2704, 3.6, 0, 0, 23215);
        WarriorClass warrior = new WarriorClass(pStats, secondaryStats);
        CompleteStats completeStats = warrior.getCompleteStats();
        System.out.println(completeStats.toString());
    }
}