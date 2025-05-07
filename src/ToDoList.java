import java.util.Iterator;

public class ToDoList implements Comparable<ToDoList>, Iterable<ToDoList>{
    private String title;
    private String description;
    private int priority;

    public ToDoList() {
    }

    public ToDoList(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "ToDoList{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                '}';
    }

    @Override
    public int compareTo(ToDoList other) {
        if (this.priority == other.priority) {
            return this.title.compareTo(other.title);
        } else {
            return Integer.compare(other.priority, this.priority);
        }
    }

    @Override
    public Iterator<ToDoList> iterator() {
        return null;
    }
}
