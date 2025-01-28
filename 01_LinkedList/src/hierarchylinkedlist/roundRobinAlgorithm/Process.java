package hierarchylinkedlist.roundRobinAlgorithm;

class Process {
    int processID;
    int burstTime;  // Total time required by the process
    int remainingTime; // Remaining time for the process to execute
    int priority;
    Process next;

    // Constructor to initialize a process
    public Process(int processID, int burstTime, int priority) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}