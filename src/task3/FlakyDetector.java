package task3;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FlakyDetector {

    public Set<String> failed(List<String> run) {
        Set<String> failedTests = new LinkedHashSet<>();

        for (String test : run) {
            String[] parts = test.split("\\|");

            if (parts[1].equals("FAILED")) {
                failedTests.add(parts[0]);
            }
        }

        return failedTests;
    }

    public Set<String> passed(List<String> run) {
        Set<String> passedTests = new LinkedHashSet<>();

        for (String test : run) {
            String[] parts = test.split("\\|");

            if (parts[1].equals("PASSED")) {
                passedTests.add(parts[0]);
            }
        }

        return passedTests;
    }

    public List<String> flaky(List<String> run1, List<String> run2) {
        Set<String> result = new LinkedHashSet<>(failed(run1));
        result.retainAll(passed(run2));

        return List.copyOf(result);
    }

    public Map<String, Long> statusSummary(List<String> run) {
        Map<String, Long> summary = new LinkedHashMap<>();

        for (String test : run) {
            String[] parts = test.split("\\|");
            summary.merge(parts[1], 1L, Long::sum);
        }

        return summary;
    }
}
