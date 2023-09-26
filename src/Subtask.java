import java.util.ArrayList;

public class Subtask { //подзадачи эпика
    private String name;
    private ArrayList<String> details;
    private int id;
    private String status;

    public Subtask(String name, ArrayList<String> details, int id) {
        this.name = name;
        this.details = details;
        this.id = id;
    }

    public Subtask() {

    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<String> details) {
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Subtask{" +
                "name='" + name + '\'' +
                ", details=" + details +
                ", id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
