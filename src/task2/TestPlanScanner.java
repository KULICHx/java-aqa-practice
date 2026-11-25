package task2;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestPlanScanner {
    public List<TestStep> buildPlan(Class<?> clazz) {
        List<TestStep> plan = new ArrayList<>();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(TestId.class)) {
                TestId annotation = method.getAnnotation(TestId.class);

                TestStep step = new TestStep(annotation.value(), method.getName(), annotation.order());

                plan.add(step);
            }
        }

        plan.sort(Comparator.comparingInt(TestStep::order));

        return plan;
    }
}
