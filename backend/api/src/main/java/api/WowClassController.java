package api;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import characterstatcalc.WowClass;
import characterstatcalc.Stats.CompleteStats;
import characterstatcalc.Stats.PrimaryStats;
import characterstatcalc.Stats.SecondaryStats;
import characterstatcalc.Warrior.WarriorClass;

@Controller
public class WowClassController {

    WowClass wowClass;

    @MutationMapping
    public WowClass createWowClass(
            @Argument("class") String wowClass,
            @Argument("pStats") PrimaryStats pStats,
            @Argument("sStats") SecondaryStats sStats,
            @Argument("baseStats") CompleteStats baseStats) {

        // TODO: Add other classes when model is finished.
        switch (wowClass.toLowerCase()) {
            case "warrior":
                this.wowClass = new WarriorClass(pStats, sStats, baseStats);
                System.out.println("Created new warrior with stats: " + this.wowClass.getCompleteStats().toString());
                break;
            default:
                throw new IllegalArgumentException("Unsupported class: " + wowClass);
        }

        return this.wowClass;
    }

    @QueryMapping
    public WowClass getWowClass() {
        return this.wowClass;
    }
}
