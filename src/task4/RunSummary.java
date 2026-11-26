
package task4;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RunSummary {

    public void printSummary(List<TestResult> run) {
        Map<Status, List<String>> byStatus = run.stream()
                .collect(Collectors.groupingBy(
                        TestResult::status,
                        Collectors.mapping(
                                TestResult::name,
                                Collectors.toList()
                        )
                ));

        List<String> top3 = run.stream()
                .sorted(Comparator.comparingLong(TestResult::durationMs).reversed())
                .limit(3)
                .map(TestResult::name)
                .toList();

        double averagePassedMs = run.stream()
                .filter(test -> test.status() == Status.PASSED)
                .collect(Collectors.averagingLong(TestResult::durationMs));

        List<String> passed = byStatus.getOrDefault(Status.PASSED, List.of());
        List<String> failed = byStatus.getOrDefault(Status.FAILED, List.of());
        List<String> skipped = byStatus.getOrDefault(Status.SKIPPED, List.of());

        System.out.println("=== Сводка прогона ===");
        System.out.println("PASSED (" + passed.size() + "): " + String.join(", ", passed));
        System.out.println("FAILED (" + failed.size() + "): " + String.join(", ", failed));
        System.out.println("SKIPPED (" + skipped.size() + "): " + String.join(", ", skipped));
        System.out.println("Топ-3 долгих: " + String.join(", ", top3));
        System.out.println("Среднее время прошедших: " + averagePassedMs + " ms");
    }
}
