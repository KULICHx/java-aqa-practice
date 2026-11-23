package task1;

public record TestResult(String name, Status status, long durationMs) {

    public enum Status {
        PASSED,
        FAILED,
        SKIPPED
    }
}