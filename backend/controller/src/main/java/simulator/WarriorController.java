package simulator;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import simulator.Stats.CompleteStats;
import simulator.Stats.PrimaryStats;
import simulator.Stats.SecondaryStats;
import simulator.Warrior.WarriorClass;

@Controller
public class WarriorController {

    WarriorClass warriorClass;

    @MutationMapping
    public WarriorClass createWarrior(@Argument("pStats") PrimaryStats pStats,
            @Argument("sStats") SecondaryStats sStats,
            @Argument("baseStats") CompleteStats baseStats) {

        this.warriorClass = new WarriorClass(pStats, sStats, baseStats);
        System.out.println("Created new warrior with stats: " + this.warriorClass.getCompleteStats().toString());
        return this.warriorClass;
    }

    @QueryMapping
    public WarriorClass getWarrior() {
        return this.warriorClass;
    }
}
