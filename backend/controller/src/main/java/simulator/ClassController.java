package simulator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import simulator.Stats.PrimaryStats;
import simulator.Stats.SecondaryStats;
import simulator.Warrior.WarriorClass;

@RestController
@Deprecated
public class ClassController {

        // TODO: Works but bad
        @GetMapping("/warrior")
        public String warrior(@RequestParam(value = "primaryStats", defaultValue = "") String pStats,
                        @RequestParam(value = "secondaryStats", defaultValue = "") String sStats) {

                String[] primaryStatsAsList = pStats.split("_");
                String[] secondaryStatsAsList = sStats.split("_");

                PrimaryStats primaryStats = new PrimaryStats(Double.parseDouble(primaryStatsAsList[0]),
                                Double.parseDouble(primaryStatsAsList[1]), Double.parseDouble(primaryStatsAsList[2]),
                                Double.parseDouble(primaryStatsAsList[3]), 0);

                SecondaryStats secondaryStats = new SecondaryStats(Double.parseDouble(secondaryStatsAsList[0]),
                                Double.parseDouble(secondaryStatsAsList[1]),
                                Double.parseDouble(secondaryStatsAsList[2]),
                                Double.parseDouble(secondaryStatsAsList[3]),
                                Double.parseDouble(secondaryStatsAsList[4]),
                                Double.parseDouble(secondaryStatsAsList[5]),
                                Double.parseDouble(secondaryStatsAsList[6]),
                                Double.parseDouble(secondaryStatsAsList[7]),
                                Double.parseDouble(secondaryStatsAsList[8]));

                return new WarriorClass(primaryStats, secondaryStats).getCalculatedStatsByClass().toString();
        }
}
