import java.util.*;

public class TaskManagerApp {

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Task task1 = new Task("Comprar leite");
        Task task2 = new Task("Estudar Java");

        taskManager.addTask(task1);
        taskManager.addTask(task2);

        System.out.println("Lista de Tarefas:");
        taskManager.listTasks();

        taskManager.completeTask(task1);
        taskManager.listTasks();
    }
}

class TaskManager {
    private List<Task> tasks = new ArrayList<>();
    private TaskSortingStrategy sortingStrategy = new SortByPriorityStrategy();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void completeTask(Task task) {
        task.complete();
    }

    public void listTasks() {
        sortingStrategy.sort(tasks).forEach(task -> System.out.println(task));
    }
}

class Task {
    private String name;
    private boolean isCompleted = false;

    public Task(String name) {
        this.name = name;
    }

    public void complete() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return (isCompleted ? "[Completa] " : "[Pendente] ") + name;
    }
}

interface TaskSortingStrategy {
    List<Task> sort(List<Task> tasks);
}

class SortByPriorityStrategy implements TaskSortingStrategy {
    @Override
    public List<Task> sort(List<Task> tasks) {
        // Como estamos simplificando, vamos considerar todas as tarefas com a mesma
        // prioridade
        return tasks;
    }
}