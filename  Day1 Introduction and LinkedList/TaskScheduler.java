class Task {
    int taskId;
    String name;
    int priority;
    String dueDate;

    Task next;  

    public Task(int taskId, String name, int priority, String dueDate) {
        this.taskId = taskId;
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}   

class TaskSchedulerLinkedList {
    private Task head = null;
    private Task tail = null;
    private Task current = null;

    // Add at beginning
    public void addAtBeginning(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            newTask.next = head;
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head;
        }
    }

    // Add at end
    public void addAtEnd(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            newTask.next = head;
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head;
        }
    }

    // Add at specific position (1-based)
    public void addAtPosition(int pos, int id, String name, int priority, String dueDate) {
        if (pos <= 1) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }

        Task newTask = new Task(id, name, priority, dueDate);
        Task temp = head;
        int count = 1;

        while (count < pos - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }

        newTask.next = temp.next;
        temp.next = newTask;

        if (temp == tail) {
            tail = newTask;
            tail.next = head;
        }
    }

    // Remove by Task ID
    public void removeById(int id) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        Task curr = head;
        Task prev = tail;

        do {
            if (curr.taskId == id) {
                if (curr == head && curr == tail) {
                    head = tail = null;
                } else if (curr == head) {
                    head = head.next;
                    tail.next = head;
                } else if (curr == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = curr.next;
                }
                System.out.println("Task ID " + id + " removed.");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);

        System.out.println("Task ID " + id + " not found.");
    }

    // View current task
    public void viewCurrentTask() {
        if (current == null) current = head;
        if (current != null) {
            printTask(current);
        } else {
            System.out.println("No tasks available.");
        }
    }

    // Move to next task
    public void moveToNextTask() {
        if (current == null) current = head;
        else current = current.next;

        viewCurrentTask();
    }

    // Display all tasks
    public void displayAll() {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        Task temp = head;
        System.out.println("All Tasks:");
        do {
            printTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // Search by Priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        Task temp = head;
        boolean found = false;

        do {
            if (temp.priority == priority) {
                printTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority: " + priority);
        }
    }

    // Utility
    private void printTask(Task task) {
        System.out.println("Task ID: " + task.taskId +
                ", Name: " + task.name +
                ", Priority: " + task.priority +
                ", Due: " + task.dueDate);
    }
}



class TaskScheduler {
    public static void main(String[] args) {
        TaskSchedulerLinkedList scheduler = new TaskSchedulerLinkedList();

        scheduler.addAtEnd(1, "Submit Report", 2, "2025-04-10");
        scheduler.addAtBeginning(2, "Prepare Slides", 1, "2025-04-09");
        scheduler.addAtPosition(2, 3, "Fix Bugs", 3, "2025-04-08");
        scheduler.addAtEnd(4, "Deploy App", 2, "2025-04-11");

        scheduler.displayAll();

        System.out.println("\nSearching tasks with priority 2:");
        scheduler.searchByPriority(2);

        System.out.println("\nViewing tasks one by one:");
        scheduler.viewCurrentTask();
        scheduler.moveToNextTask();
        scheduler.moveToNextTask();

        System.out.println("\nRemoving Task ID 3:");
        scheduler.removeById(3);
        scheduler.displayAll();
    }
}
