package simulator.Stats;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class ActualSimStats {

    private double attackPower;
    private double weaponDPS;
    private double weaponSpeed;
    private double critChance;
    private double masteryChance;

    public ActualSimStats(double attackPower, double wepDPS, double weaponSpeed,
            double critChance, double masteryChance) {
        this.attackPower = attackPower;
        this.weaponDPS = wepDPS;
        this.weaponSpeed = weaponSpeed;
        this.critChance = critChance;
        this.masteryChance = masteryChance;
    }

    public ArrayList<Double> getStats() {
        ArrayList<Double> outList = new ArrayList<Double>();

        outList.add(this.attackPower);
        outList.add(this.weaponDPS);
        outList.add(this.weaponSpeed);
        outList.add(this.critChance);
        outList.add(this.masteryChance);

        return outList;
    }

    @Override
    public String toString() {
        String s = "";
        Field[] fields = this.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                s += field.getName() + ": " + field.get(this) + ", ";
            } catch (IllegalAccessException e) {
            }
        }
        return s;
    }
}
