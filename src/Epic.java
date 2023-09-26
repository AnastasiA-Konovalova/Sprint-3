import java.util.ArrayList;

public class Epic { //эпик задачи
    private String name;
    private ArrayList<Subtask> subtasks;
    private int id;
    private String status;

    public Epic(String name, ArrayList<Subtask> subtasks, int id) {
        this.name = name;
        this.subtasks = subtasks;
        this.id = id;
    }

    public Epic() {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Subtask> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(ArrayList<Subtask> subtasks) {
        this.subtasks = subtasks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Epic{" +
                "name='" + name + '\'' +
                ", subtasks=" + subtasks +
                ", id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
