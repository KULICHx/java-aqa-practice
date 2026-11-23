package task1;

import java.util.*;

public class TestLogParser {

    public ParseResult parse(List<String> lines) {

        // Record автоматически реализует equals() и hashCode()
        // по всем компонентам. Для сохранения последней попытки
        // используем имя теста как ключ Map.
        Map<String, TestResult> testResults = new LinkedHashMap<>();
        List<String> errors = new ArrayList<>();

        for (String line : lines) {
            try {
                TestResult result = parse(line);
                testResults.put(result.name(), result);
            } catch (IllegalArgumentException e) {
                errors.add(line + " -> " + e.getMessage());
            }
        }
        return new ParseResult(new ArrayList<>(testResults.values()), errors);
    }

    public TestResult parse(String line) {


        TestResult.Status status;
        long durationMs;

        String[] parts = line.split("\\|", -1);
        if (parts.length != 3) throw new IllegalArgumentException("Некорректный формат строки: " + line);
        String name = parts[0];
        if (name.isBlank()) throw new IllegalArgumentException("Пустое имя: " + line);

        try {
            status = TestResult.Status.valueOf(parts[1]);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Неизвестный статус: " + parts[1], e);
        }
        try {
            durationMs = Long.parseLong(parts[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Некорректная длительность: " + parts[2], e);
        }
        if (durationMs < 0) throw new IllegalArgumentException("Отрицательная длительность: " + line);
        return new TestResult(name, status, durationMs);
    }

    public Optional<TestResult> firstFailed(List<TestResult> results) {
        for (TestResult result : results) {
            if (result.status() == TestResult.Status.FAILED) return Optional.of(result);
        }
        return Optional.empty();
    }
}
