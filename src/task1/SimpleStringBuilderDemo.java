package task1;

public class SimpleStringBuilderDemo {
    public static void main(String[] args) {
        SimpleStringBuilder builder = new SimpleStringBuilder();

        builder.append("Hello");
        builder.append(", ");
        builder.append("world");
        System.out.println("После append: " + builder);

        builder.undo();
        System.out.println("После undo: " + builder);

        builder.append("AQA!");
        System.out.println("После нового append: " + builder);

        builder.undo();
        builder.undo();
        builder.undo();
        System.out.println("После всех отмен: [" + builder + "]");

        builder.undo();
        System.out.println("Undo при пустой истории: [" + builder + "]");
    }
}