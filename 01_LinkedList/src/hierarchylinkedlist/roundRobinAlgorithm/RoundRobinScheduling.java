package hierarchylinkedlist.roundRobinAlgorithm;

public class RoundRobinScheduling {
    public static void main(String[] args) {
        CircularLinkedList processQueue = new CircularLinkedList();

        // Add some processes to the list
        processQueue.addProcess(1, 10, 1);
        processQueue.addProcess(2, 5, 2);
        processQueue.addProcess(3, 8, 3);
        processQueue.addProcess(4, 6, 4);

        // Display initial process list
        processQueue.displayProcessList();

        // Simulate Round-Robin Scheduling with a time quantum of 4 units
        processQueue.roundRobinScheduling(4);
    }
}