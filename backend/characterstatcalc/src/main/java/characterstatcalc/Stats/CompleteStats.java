package characterstatcalc.Stats;

public class CompleteStats {
    private PrimaryStats primaryStats;
    private SecondaryStats secondaryStats;

    // To be calculated based on the primary and secondary stats
    private int attackPower;
    private int spellPower;
    private double hitChance;
    private double expertiseChance;
    private double critChance;
    private double masteryChance;
    private double dodgeChance;
    private double parryChance;
    private double blockChance;

    private double armor;

    public CompleteStats(PrimaryStats pStats, SecondaryStats sStats, int attackPower, int spellPower, double hitChance,
            double expertiseChance, double critChance,
            double masteryChance, double dodgeChance, double parryChance, double blockChance, double armor) {
        this.primaryStats = pStats;
        this.secondaryStats = sStats;
        this.attackPower = attackPower;
        this.spellPower = spellPower;
        this.hitChance = hitChance;
        this.expertiseChance = expertiseChance;
        this.critChance = critChance;
        this.masteryChance = masteryChance;
        this.dodgeChance = dodgeChance;
        this.parryChance = parryChance;
        this.blockChance = blockChance;
        this.armor = armor;
    }

    public CompleteStats() {
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

    public double getHitChance() {
        return this.hitChance;
    }

    public double getExpertiseChance() {
        return this.expertiseChance;
    }

    public double getCritChance() {
        return critChance;
    }

    public double getMasteryChance() {
        return masteryChance;
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

    public void setPrimaryStats(PrimaryStats primaryStats) {
        this.primaryStats = primaryStats;
    }

    public void setSecondaryStats(SecondaryStats secondaryStats) {
        this.secondaryStats = secondaryStats;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public void setSpellPower(int spellPower) {
        this.spellPower = spellPower;
    }

    public void setHitChance(double h) {
        this.hitChance = h;
    }

    public void setExpertiseChance(double e) {
        this.expertiseChance = e;
    }

    public void setCritChance(double critChance) {
        this.critChance = critChance;
    }

    public void setMasteryChance(double masteryChance) {
        this.masteryChance = masteryChance;
    }

    public void setDodgeChance(double dodgeChance) {
        this.dodgeChance = dodgeChance;
    }

    public void setParryChance(double parryChance) {
        this.parryChance = parryChance;
    }

    public void setBlockChance(double blockChance) {
        this.blockChance = blockChance;
    }

    public void setArmor(double armor) {
        this.armor = armor;
    }

    public String toString() {
        return "CompleteStats{" +
                ", attackPower=" + attackPower + "\n" +
                ", spellPower=" + spellPower + "\n" +
                ", hitChance=" + hitChance + "\n" +
                ", expertiseChance=" + expertiseChance + "\n" +
                ", critChance=" + critChance + "\n" +
                ", masteryChance=" + masteryChance + "\n" +
                ", dodgeChance=" + dodgeChance + "\n" +
                ", parryChance=" + parryChance + "\n" +
                ", blockChance=" + blockChance + "\n" +
                ", armor=" + armor +
                '}';
    }
}
