public class Task {
    String name;
    boolean isDone;

    Task(String name) {
        this.name = name;
        this.isDone = false;
    }

    public String toString() {
        String status = isDone ? "[DONE]" : "[TODO]";
        return status + " " + name;
    }
}