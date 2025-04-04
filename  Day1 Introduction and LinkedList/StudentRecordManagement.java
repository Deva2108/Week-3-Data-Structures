class Student {
    int rollNumber;
    String name;
    int age;
    String grade;
    Student next;

    public Student(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkedList {
    private Student head;

    // Add student at beginning
    public void addAtBeginning(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        newStudent.next = head;
        head = newStudent;
    }

    // Add student at end
    public void addAtEnd(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }

        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    // Add student at specific position (0-based)
    public void addAtPosition(int position, int rollNumber, String name, int age, String grade) {
        if (position == 0) {
            addAtBeginning(rollNumber, name, age, grade);
            return;
        }

        Student newStudent = new Student(rollNumber, name, age, grade);
        Student temp = head;

        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    // Delete student by roll number
    public void deleteByRollNumber(int rollNumber) {
        if (head == null) return;

        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }

        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Student with roll number " + rollNumber + " not found ");
            return;
        }

        temp.next = temp.next.next;
    }

    // Search student by roll number
    public void searchByRollNumber(int rollNumber) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                System.out.println("Found: Roll No: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    // Update grade by roll number
    public void updateGradeByRollNumber(int rollNumber, String newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                temp.grade = newGrade;
                System.out.println("Updated grade for Roll No " + rollNumber);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    // Display all student records
    public void displayAll() {
        Student temp = head;
        if (temp == null) {
            System.out.println("No student records found.");
            return;
        }
        while (temp != null) {
            System.out.println("Roll No: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
}

public class StudentRecordManagement {
    public static void main(String[] args) {
        StudentLinkedList list = new StudentLinkedList();

        list.addAtBeginning(101, "Alice", 20, "A");
        list.addAtEnd(102, "Bob", 21, "B");
        list.addAtPosition(1, 103, "Charlie", 19, "C");

        System.out.println("All Students:");
        list.displayAll();

        System.out.println("\nSearching for roll number 102:");
        list.searchByRollNumber(102);

        System.out.println("\nUpdating grade for roll number 103:");
        list.updateGradeByRollNumber(103, "A+");

        System.out.println("\nAll Students After Update:");
        list.displayAll();

        System.out.println("\nDeleting student with roll number 101:");
        list.deleteByRollNumber(101);

        System.out.println("\nAll Students After Deletion:");
        list.displayAll();
    }
}
