package task1;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimpleStringBuilder {

    private String text = "";
    private final Deque<String> history = new ArrayDeque<>();

    public void append(String s) {
        history.push(text);
        text += s;
    }
    public void undo(){
        if (!history.isEmpty()) {
            text = history.pop();
        }
    }
    @Override
    public String toString() {
        return text;
    }
}
