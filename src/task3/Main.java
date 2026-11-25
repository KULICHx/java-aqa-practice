package task3;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> run1 = List.of("LoginTest|PASSED", "CreateTaskTest|FAILED", "CommentTest|FAILED", "LogoutTest|PASSED");

        List<String> run2 = List.of("LoginTest|PASSED", "CreateTaskTest|PASSED", "CommentTest|FAILED", "StatsTest|PASSED");

        FlakyDetector detector = new FlakyDetector();

        System.out.println("Flaky-кандидаты: " + detector.flaky(run1, run2));
        System.out.println("Прогон 2, сводка: " + detector.statusSummary(run2));

        FrequencyCounter counter = new FrequencyCounter();

        String[] words = {"up", "down", "up", "up", "left"};
        Integer[] numbers = {3, 1, 3, 3, 7, 1};

        System.out.println();
        System.out.println("Частотный анализ:");
        System.out.println(counter.frequency(words));
        System.out.println(counter.frequency(numbers));
    }
}
