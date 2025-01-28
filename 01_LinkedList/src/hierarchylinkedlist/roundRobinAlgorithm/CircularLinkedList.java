package hierarchylinkedlist.roundRobinAlgorithm;

class CircularLinkedList {
    private Process head = null;
    private Process tail = null;

    // Add a new process at the end of the circular list
    public void addProcess(int processID, int burstTime, int priority) {
        Process newProcess = new Process(processID, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            newProcess.next = head;  // Making it circular
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;  // Maintaining circularity
        }
    }

    // Remove a process by Process ID after execution
    public void removeProcess(int processID) {
        if (head == null) {
            System.out.println("The process list is empty.");
            return;
        }
        Process current = head;
        Process prev = null;

        do {
            if (current.processID == processID) {
                if (prev == null) {
                    head = head.next;
                    tail.next = head;
                } else {
                    prev.next = current.next;
                    if (current == tail) {
                        tail = prev;
                    }
                }
                System.out.println("Process " + processID + " has been removed.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        System.out.println("Process not found.");
    }

    // Simulate Round-Robin Scheduling
    public void roundRobinScheduling(int timeQuantum) {
        Process current = head;
        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;
        int numberOfProcesses = 0;
        int totalBurstTime = 0;

        // First calculate the total burst time and number of processes
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        Process temp = head;
        do {
            totalBurstTime += temp.burstTime;
            numberOfProcesses++;
            temp = temp.next;
        } while (temp != head);

        // Start Round Robin Scheduling
        while (current != null && numberOfProcesses > 0) {
            if (current.remainingTime > timeQuantum) {
                current.remainingTime -= timeQuantum;
                totalWaitingTime += timeQuantum;
                totalTurnAroundTime += timeQuantum;
                current = current.next;
            } else {
                totalWaitingTime += current.remainingTime;
                totalTurnAroundTime += current.remainingTime;
                System.out.println("Process " + current.processID + " finished execution.");
                removeProcess(current.processID);  // Remove the completed process
                numberOfProcesses--;
                current = current.next;
            }
            displayProcessList();
        }

        // Calculate average waiting and turn-around time
        if (numberOfProcesses == 0) {
            System.out.println("Average Waiting Time: " + (double) totalWaitingTime / totalBurstTime);
            System.out.println("Average Turn-Around Time: " + (double) totalTurnAroundTime / totalBurstTime);
        }
    }

    // Display the process list after each round
    public void displayProcessList() {
        if (head == null) {
            System.out.println("No processes to display.");
            return;
        }
        Process current = head;
        System.out.println("Processes in the circular queue:");
        do {
            System.out.println("Process ID: " + current.processID + ", Remaining Time: " + current.remainingTime);
            current = current.next;
        } while (current != head);
    }
}