package task2;

import java.util.List;

public class Main {
    static void main() {
        TestPlanScanner scanner = new TestPlanScanner();
        List<TestStep> steps = scanner.buildPlan(Checklist.class);
        if (steps.isEmpty()) {
            System.out.println("Кейсов нет");
        } else {
            System.out.println("План прогона для Checklist:");
            for (TestStep step : steps) {
                System.out.println("\t" + step.order() + ". "
                        + step.id() + " → "
                        + step.methodName());
            }
        }
    }
}
