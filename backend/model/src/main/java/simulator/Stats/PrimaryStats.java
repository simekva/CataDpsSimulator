package simulator.Stats;

public class PrimaryStats {

    private int strength;
    private int agility;
    private int stamina;
    private int intellect;
    private int spirit;

    public PrimaryStats(int strength, int agility, int stamina, int intellect, int spirit) {
        this.strength = strength;
        this.agility = agility;
        this.stamina = stamina;
        this.intellect = intellect;
        this.spirit = spirit;
    }

    public PrimaryStats() {
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getStamina() {
        return stamina;
    }

    public int getIntellect() {
        return intellect;
    }

    public int getSpirit() {
        return spirit;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    public void setSpirit(int spirit) {
        this.spirit = spirit;
    }
}
