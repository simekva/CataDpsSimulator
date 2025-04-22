package simulator.Warrior;

import simulator.WowClass;
import simulator.Stats.ActualSimStats;
import simulator.Stats.PrimaryStats;
import simulator.Stats.SecondaryStats;

public class WarriorClass implements WowClass {

    private PrimaryStats basePrimaryStats = new PrimaryStats(189, 123, 37, 173, 0);
    private SecondaryStats baseSecondaryStats = new SecondaryStats(0, 0, 89.64, 0, 1434.24, 0, 0, 0, 0);

    private ActualSimStats stats;

    public WarriorClass(PrimaryStats pStats, SecondaryStats sStats) {
        this.stats = this.calculateActualStats(pStats, sStats);
    }

    private ActualSimStats calculateActualStats(PrimaryStats pStats, SecondaryStats sStats) {

        ///////////////////////////////////////
        /// AP = Strength * 2 + Agility * 1 ///
        ///////////////////////////////////////
        Double allStrength = basePrimaryStats.getStat("strength") + pStats.getStat("strength");
        Double attackPower = allStrength * 2;
        Double allAgility = basePrimaryStats.getStat("agility") + pStats.getStat("agility");
        attackPower += allAgility * 2;

        /////////////////////////////////////
        /// 128.057 haste = 1% faster speed. ///
        /// Haste / 128.057 / 100% = speed increase. ///
        /// Weapon speed / speed increase = new Weapon Speed ///
        //////////////////////////////////////////////////////////
        Double weaponSpeed = sStats.getStat("weaponSpeed");
        weaponSpeed = weaponSpeed / (1 + ((sStats.getStat("hasteRating") / 128.057)) / 100);

        /////////////////////////////////////////////////////
        /// wepDPS = minDamage + maxDamage / 2 / wepSpeed ///
        /// 14AP = +1 wepDPS ///
        /////////////////////////////////////////////////////
        Double weaponDPS = (sStats.getStat("minWeaponDamage") + sStats.getStat("maxWeaponDamage") / 2)
                / weaponSpeed;
        weaponDPS = weaponDPS + (attackPower / 14);

        Double critRating = baseSecondaryStats.getStat("critRating");
        critRating = critRating + sStats.getStat("critRating");

        Double critChance = ((critRating / 179.28))
                + (((basePrimaryStats.getStat("agility") + pStats.getStat("agility")) / 242));

        Double masteryRating = sStats.getStat("masteryRating");
        int masteryPoints = (int) Math.floor(masteryRating / 179.28) + 8;
        int masteryChance = (int) Math.ceil(masteryPoints * 2.2);

        ActualSimStats simStats = new ActualSimStats(Math.round(attackPower * 100.0) / 100.0,
                Math.round(weaponDPS * 100.0) / 100.0, Math.round(weaponSpeed * 100.0) / 100.0,
                Math.round(critChance * 100.0) / 100.0,
                masteryChance);

        return simStats;
    }

    @Override
    public ActualSimStats getCalculatedStatsByClass() {
        return this.stats;
    }
}