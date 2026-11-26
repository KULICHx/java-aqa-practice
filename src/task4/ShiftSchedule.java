
package task4;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShiftSchedule {

    public void printSharedDays(List<WorkSheet> sheets) {
        Map<DayOfWeek, Long> dayCounts = sheets.stream()
                .flatMap(sheet -> sheet.workDays().stream())
                .collect(Collectors.groupingBy(
                        day -> day,
                        Collectors.counting()
                ));

        List<DayOfWeek> sharedDays = dayCounts.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();

        sharedDays.forEach(System.out::println);
    }
}
