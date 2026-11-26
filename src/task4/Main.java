package task4;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<TestResult> run = List.of(
                new TestResult("LoginTest", Status.PASSED, 120),
                new TestResult("CreateTaskTest", Status.PASSED, 940),
                new TestResult("UpdateStatusTest", Status.FAILED, 2100),
                new TestResult("CommentTest", Status.PASSED, 380),
                new TestResult("DeleteTaskTest", Status.FAILED, 760),
                new TestResult("StatsTest", Status.SKIPPED, 0),
                new TestResult("LogoutTest", Status.PASSED, 90)
        );

        RunSummary summary = new RunSummary();
        summary.printSummary(run);

        System.out.println();
        test();

    }

    private static void test() {
        var denSheet = new WorkSheet("Денис", List.of(
                DayOfWeek.TUESDAY, DayOfWeek.THURSDAY, DayOfWeek.SUNDAY
        ));

        var benSheet = new WorkSheet("Бен", List.of(
                DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY, DayOfWeek.SATURDAY
        ));

        var lisSheet = new WorkSheet("Лиза", List.of(
                DayOfWeek.THURSDAY, DayOfWeek.WEDNESDAY, DayOfWeek.FRIDAY
        ));

        var sheets = List.of(denSheet, benSheet, lisSheet);

        ShiftSchedule shiftSchedule = new ShiftSchedule();
        shiftSchedule.printSharedDays(sheets);

    }
}
