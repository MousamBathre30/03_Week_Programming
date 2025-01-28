package singlylinkedlist.studentrecordmanagement;

class StudentRecords {
    private Student head;

    // Add a new student at the beginning
    public void addStudentAtBeginning(int rollNumber, String name, int age, char grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    // Add a new student at the end
    public void addStudentAtEnd(int rollNumber, String name, int age, char grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newStudent;
    }

    // Add a new student at a specific position
    public void addStudentAtPosition(int position, int rollNumber, String name, int age, char grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (position == 1) {
            newStudent.next = head;
            head = newStudent;
            return;
        }
        Student current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of bounds.");
            return;
        }
        newStudent.next = current.next;
        current.next = newStudent;
    }

    // Delete a student by Roll Number
    public void deleteStudentByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }
        Student current = head;
        while (current.next != null && current.next.rollNumber != rollNumber) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
            return;
        }
        current.next = current.next.next;
    }

    // Search for a student by Roll Number
    public void searchStudentByRollNumber(int rollNumber) {
        Student current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                System.out.println("Student Found: " + current.rollNumber + ", " + current.name + ", " + current.age + ", " + current.grade);
                return;
            }
            current = current.next;
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found.");
    }

    // Update a student's grade by Roll Number
    public void updateStudentGrade(int rollNumber, char newGrade) {
        Student current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                current.grade = newGrade;
                System.out.println("Grade updated for Roll Number " + rollNumber);
                return;
            }
            current = current.next;
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found.");
    }

    // Display all student records
    public void displayAllStudents() {
        if (head == null) {
            System.out.println("No student records available.");
            return;
        }
        Student current = head;
        while (current != null) {
            System.out.println("Roll Number: " + current.rollNumber + ", Name: " + current.name + ", Age: " + current.age + ", Grade: " + current.grade);
            current = current.next;
        }
    }
}