import java.util.ArrayList;
import java.util.HashMap;

public class Task { // отдельно стоящая задача
    private String name;
    private ArrayList<String> details;
    private int id;
    private String status;



    public Task(String name, ArrayList<String> details, int identificationNumber) {
        this.name = name;
        this.details = details;
        this.id = identificationNumber;
    }

    public Task() {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", details=" + details +
                ", id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}

    /*Простейшим кирпичиком такой системы является задача (англ. task). У задачи есть следующие свойства:
        Название, кратко описывающее суть задачи (например, «Переезд»).
        Описание, в котором раскрываются детали.
        Уникальный идентификационный номер задачи, по которому её можно будет найти.*/