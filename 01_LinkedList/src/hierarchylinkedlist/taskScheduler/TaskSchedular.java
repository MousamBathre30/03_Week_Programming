package hierarchylinkedlist.taskScheduler;

class TaskScheduler {
    private Task head = null;
    private Task tail = null;
    private Task current = null; // For tracking the current task during traversal

    // Add a task at the beginning
    public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head; // Maintain circular nature
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head; // Update tail's next to point to new head
        }
    }

    // Add a task at the end
    public void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (tail == null) {
            head = tail = newTask;
            tail.next = head; // Maintain circular nature
        } else {
            tail.next = newTask;
            newTask.next = head;
            tail = newTask;
        }
    }

    // Add a task at a specific position
    public void addTaskAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {
        if (position <= 1) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        Task current = head;
        for (int i = 1; i < position - 1 && current != tail; i++) {
            current = current.next;
        }
        newTask.next = current.next;
        current.next = newTask;
        if (current == tail) {
            tail = newTask;
            tail.next = head; // Maintain circular nature
        }
    }

    // Remove a task by Task ID
    public void removeTaskById(int taskId) {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }

        Task current = head, previous = tail;
        do {
            if (current.taskId == taskId) {
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) {
                    tail = previous;
                    tail.next = head;
                } else {
                    previous.next = current.next;
                }
                System.out.println("Task with ID " + taskId + " removed successfully.");
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        System.out.println("Task with ID " + taskId + " not found.");
    }

    // View the current task and move to the next task
    public void viewAndMoveToNextTask() {
        if (current == null) {
            current = head;
        }
        if (current == null) {
            System.out.println("No tasks in the list.");
        } else {
            System.out.println("Current Task: " + current.taskName + " (ID: " + current.taskId + ", Priority: " + current.priority + ", Due Date: " + current.dueDate + ")");
            current = current.next; // Move to the next task
        }
    }

    // Display all tasks starting from the head
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }

        System.out.println("Tasks in the circular list:");
        Task current = head;
        do {
            System.out.println("Task ID: " + current.taskId + ", Name: " + current.taskName + ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
            current = current.next;
        } while (current != head);
    }

    // Search for a task by Priority
    public void searchTaskByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }

        boolean found = false;
        Task current = head;
        do {
            if (current.priority == priority) {
                System.out.println("Found: Task ID " + current.taskId + ", Name: " + current.taskName + ", Due Date: " + current.dueDate);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No tasks found with priority " + priority + ".");
        }
    }
}