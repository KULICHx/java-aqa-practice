package task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        List<String> lines = new ArrayList<>();
        Path logPath = Paths.get("run.log");

        try (BufferedReader reader = Files.newBufferedReader(logPath, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла логов: " + e.getMessage());
            return;
        }
        TestLogParser parser = new TestLogParser();
        ParseResult result = parser.parse(lines);
        printReport(result, parser);
    }

    private static void printReport(ParseResult result, TestLogParser parser) {
        Optional<TestResult> firstFailed = parser.firstFailed(result.results());

        System.out.println("Результаты:");
        for (TestResult test : result.results()) {
            System.out.println(" " + test.name() + " — " + test.status() + " (" + test.durationMs() + " ms)");
        }

        if (result.errors().isEmpty()) {
            System.out.println("Битые строки: нет");
        } else {
            System.out.println("Битые строки:");

            for (String error : result.errors()) {
                System.out.println("  " + error);
            }
        }

        if (firstFailed.isPresent()) {
            System.out.println("Первый упавший: " +  firstFailed.get().name());
        }
        else
            System.out.println("Первый упавший: нет");
    }
}