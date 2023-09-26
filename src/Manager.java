import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Manager {
    private HashMap<Integer, Task> taskMap;
    private HashMap<Integer, Epic> epicMap;
    private HashMap<Integer, Subtask> subTaskMap;

    private Integer taskIdCounter = 1;
    private Integer subIdCounter = 1;
    private Integer epicIdCounter = 1;

    public Manager() {
        this.taskMap = new HashMap<>();
        this.epicMap = new HashMap<>();
        this.subTaskMap = new HashMap<>();
    }

    public ArrayList<Task> findAllTasks() { //Получение списка всех задач.
        Set<Integer> keys = taskMap.keySet();
        ArrayList<Task> result = new ArrayList<>();
        for (Integer key : keys) {
            result.add(taskMap.get(key));
        }

        return result;

    }

    public ArrayList<Epic> findAllEpics() { //Получение списка всех эпиков.
        Set<Integer> keys = epicMap.keySet();
        ArrayList<Epic> result = new ArrayList<>();
        for (Integer key : keys) {
            result.add(epicMap.get(key));
        }

        return result;
    }

    public ArrayList<Subtask> findAllSubtasks() { //Получение списка всех подзадач.
        Set<Integer> keys = subTaskMap.keySet();
        ArrayList<Subtask> result = new ArrayList<>();
        for (Integer key : keys) {
            result.add(subTaskMap.get(key));
        }

        return result;
    }

    public boolean deleteTask() { //Удаление всех задач.
        taskMap.clear();

        return true;
    }

    public boolean deleteEpic() { //Удаление всех эпиков'.
        epicMap.clear();
        return true;
    }

    public boolean deleteSubtask() { //Удаление всех подзадач.
        subTaskMap.clear();
        return true;
    }


    public Task showTaskById(Integer id) { //Получение задачи по идентификатору.
        return taskMap.get(id);
    }

    public Epic showEpicById(Integer id) { //Получение эпика по идентификатору.
        return epicMap.get(id);
    }

    public Subtask showSubtaskById(Integer id) { //Получение подзадачи по идентификатору.
        return subTaskMap.get(id);
    }

    public void createTask(Task task) { //Создание задача.
        task.setId(taskIdCounter++);
        taskMap.put(task.getId(), task);
    }

    public void createEpic(Epic epic) { //Создание эпик.
        epic.setId(epicIdCounter++);
        epicMap.put(epic.getId(), epic);
    }

    public void createSubTask(Subtask subtask) { //Создание подзадача.
        subtask.setId(subIdCounter++);
        subTaskMap.put(subtask.getId(), subtask);
    }

    public void updateTask(Task updateTask) { //Обновление задача.
        Task task = taskMap.get(updateTask.getId());

        task.setName(updateTask.getName());
        task.setDetails(updateTask.getDetails());
        ArrayList<String> tasks = updateTask.getDetails();
        if (tasks == null || tasks.isEmpty()) {
            task.setStatus("NEW");
            return;
        }
        task.setStatus(updateTask.getStatus());
    }

    public void updateSubTask(Subtask updateSubTask) { //Обновление задача.
        Subtask subtask = subTaskMap.get(updateSubTask.getId());

        subtask.setName(updateSubTask.getName());
        subtask.setDetails(updateSubTask.getDetails());
        ArrayList<String> tasks = updateSubTask.getDetails();
        if (tasks == null || tasks.isEmpty()) {
            subtask.setStatus("NEW");
            return;
        }
        subtask.setStatus(updateSubTask.getStatus());
    }

    public void updateEpic(Epic updateEpic) { //Обновление эпик.
        Epic epic = epicMap.get(updateEpic.getId());

        epic.setName(updateEpic.getName());
        epic.setSubtasks(updateEpic.getSubtasks());
        ArrayList<Subtask> subtasks = updateEpic.getSubtasks();
        if (subtasks == null || subtasks.isEmpty()) {
            epic.setStatus("NEW");
            return;
        }
        if (checkSubTasksDone(updateEpic.getSubtasks())) {
            epic.setStatus("DONE");
            return;
        }
        if (checkSubTasksNew(updateEpic.getSubtasks())) {
            epic.setStatus("NEW");
            return;
        }
        epic.setStatus("IN_PROGRESS");
    }

    private boolean checkSubTasksNew(ArrayList<Subtask> subtasks) {
        for (Subtask subtask : subtasks) {
            if (!subtask.getStatus().equals("NEW")) {
                return false;
            }
        }
        return true;
    }

    private boolean checkSubTasksDone(ArrayList<Subtask> subtasks) {
        for (Subtask subtask : subtasks) {
            if (!subtask.getStatus().equals("DONE")) {
                return false;
            }
        }
        return true;
    }

    public void deleteByIdTask(Integer id) { //Удаление по идентификатору.
        if (taskMap.containsKey(id)) {
            taskMap.remove(id);
        } else {
            System.out.println("Такой ID отсутствует");
        }


    }

    public void deleteByIdEpic(Integer id) { //Удаление по идентификатору.
        if (epicMap.containsKey(id)) {
            epicMap.remove(id);
        } else {
            System.out.println("Такой ID отсутствует");
        }
    }

    public void deleteByIdSub(Integer id) { //Удаление по идентификатору.
        if (subTaskMap.containsKey(id)) {
            subTaskMap.remove(id);
        } else {
            System.out.println("Такой ID отсутствует");
        }
    }

    public ArrayList<Subtask> getSubtaskOfEpic(Integer idEpic) { //Получение списка всех подзадач определённого эпика.
        return epicMap.get(idEpic).getSubtasks();
    }
}
