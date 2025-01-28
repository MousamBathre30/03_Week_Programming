package hierarchylinkedlist.taskScheduler;

public class Main {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        // Add tasks
        scheduler.addTaskAtEnd(1, "Task A", 2, "2025-01-30");
        scheduler.addTaskAtEnd(2, "Task B", 1, "2025-02-05");
        scheduler.addTaskAtBeginning(3, "Task C", 3, "2025-01-28");
        scheduler.addTaskAtPosition(2, 4, "Task D", 2, "2025-02-01");

        // Display all tasks
        System.out.println("\n--- Display All Tasks ---");
        scheduler.displayAllTasks();

        // View and move to the next task
        System.out.println("\n--- View and Move to Next Task ---");
        scheduler.viewAndMoveToNextTask();
        scheduler.viewAndMoveToNextTask();

        // Search for tasks by priority
        System.out.println("\n--- Search Tasks by Priority ---");
        scheduler.searchTaskByPriority(2);

        // Remove a task
        System.out.println("\n--- Remove Task by ID ---");
        scheduler.removeTaskById(4);

        // Display all tasks after removal
        System.out.println("\n--- Display All Tasks After Removal ---");
        scheduler.displayAllTasks();
    }
}