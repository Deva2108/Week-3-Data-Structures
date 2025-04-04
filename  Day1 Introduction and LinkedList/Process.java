class Process {
    int processID;
    int burstTime;    // CPU burst time for the process
    int priority;     // Priority of the process (not used directly in RR but can be extended)
    Process next;     // Pointer to the next process in the circular linked list


    // Constructor to initialize process
    public Process(int processID, int burstTime, int priority) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}


class RoundRobinScheduler {
    private Process head;
    private int timeQuantum;


    public RoundRobinScheduler(int timeQuantum) {
        head = null;
        this.timeQuantum = timeQuantum;
    }


    // Add a new process to the end of the circular list
    public void addProcess(int processID, int burstTime, int priority) {
        Process newProcess = new Process(processID, burstTime, priority);


        if (head == null) {
            head = newProcess;
            newProcess.next = head;  // Make it circular
        } else {
            Process temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newProcess;
            newProcess.next = head;  // Make it circular
        }
    }


    // Remove a process by Process ID after its execution
    public void removeProcess(int processID) {
        if (head == null) {
            System.out.println("No processes to remove.");
            return;
        }


        Process temp = head;
        Process prev = null;


        // If head process needs to be removed
        if (head.processID == processID) {
            if (head.next == head) {  // Only one process in the list
                head = null;
            } else {
                prev = head;
                while (prev.next != head) {
                    prev = prev.next;
                }
                head = head.next;  // Update head to next process
                prev.next = head;  // Maintain the circular nature
            }
            System.out.println("Process " + processID + " removed after execution.");
            return;
        }


        // Traverse the list to find the process to be removed
        while (temp != null && temp.processID != processID) {
            prev = temp;
            temp = temp.next;
        }


        if (temp == null) {
            System.out.println("Process with ID " + processID + " not found.");
            return;
        }


        prev.next = temp.next;  // Remove the process from the circular list
        System.out.println("Process " + processID + " removed after execution.");
    }


    // Simulate the round-robin scheduling
    public void schedule() {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }


        Process current = head;
        int totalWaitingTime = 0, totalTurnaroundTime = 0;
        int completedProcesses = 0;
        int totalProcesses = countProcesses();


        while (completedProcesses < totalProcesses) {
            // If the process has remaining burst time
            if (current.burstTime > 0) {
                int executionTime = Math.min(timeQuantum, current.burstTime);
                current.burstTime -= executionTime;


                System.out.println("Executing Process ID " + current.processID + " for " + executionTime + " units.");


                if (current.burstTime == 0) {
                    completedProcesses++;
                    // Calculate waiting and turnaround time
                    totalWaitingTime += (executionTime - current.burstTime); // Simple example, can be modified to track wait time properly
                    totalTurnaroundTime += executionTime;  // In a simple RR, turnaround time is the execution time.
                    removeProcess(current.processID);  // Remove the process after execution
                }
            }
            current = current.next;  // Move to the next process in the circular list
        }


        // Display average waiting and turnaround times
        System.out.println("Average Waiting Time: " + (totalWaitingTime / totalProcesses));
        System.out.println("Average Turnaround Time: " + (totalTurnaroundTime / totalProcesses));
    }


    // Display the list of processes in the circular queue
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }


        Process temp = head;
        do {
            System.out.println("Process ID: " + temp.processID + ", Burst Time: " + temp.burstTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }


    // Count the total number of processes in the queue
    private int countProcesses() {
        if (head == null) return 0;


        int count = 0;
        Process temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }


    public static void main(String[] args) {
        // Create a round-robin scheduler with a time quantum of 4 units
        RoundRobinScheduler scheduler = new RoundRobinScheduler(4);


        // Add processes to the scheduler
        scheduler.addProcess(1, 10, 2);
        scheduler.addProcess(2, 5, 1);
        scheduler.addProcess(3, 8, 3);
        scheduler.addProcess(4, 6, 1);


        // Display the list of processes
        System.out.println("Initial List of Processes:");
        scheduler.displayProcesses();


        // Start the round-robin scheduling
        System.out.println("\nRound Robin Scheduling Simulation:");
        scheduler.schedule();


        // Display final list of processes
        System.out.println("\nFinal List of Processes:");
        scheduler.displayProcesses();
    }
}
