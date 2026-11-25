package task1;

import java.util.List;

public record ParseResult(List<TestResult> results, List<String> errors) {
}