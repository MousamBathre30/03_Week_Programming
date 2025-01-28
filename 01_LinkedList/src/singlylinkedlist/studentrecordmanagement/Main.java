package singlylinkedlist.studentrecordmanagement;

public class Main {
    public static void main(String[] args) {
        StudentRecords records = new StudentRecords();

        // Add students
        records.addStudentAtEnd(1, "John Doe", 20, 'A');
        records.addStudentAtEnd(2, "Jane Smith", 22, 'B');
        records.addStudentAtBeginning(3, "Alice Brown", 19, 'A');
        records.addStudentAtPosition(2, 4, "Charlie Black", 21, 'C');

        // Display all students
        System.out.println("All Students:");
        records.displayAllStudents();

        // Search for a student
        System.out.println("\nSearching for Roll Number 2:");
        records.searchStudentByRollNumber(2);

        // Update grade
        System.out.println("\nUpdating grade for Roll Number 4:");
        records.updateStudentGrade(4, 'B');

        // Display all students after update
        System.out.println("\nAll Students after Grade Update:");
        records.displayAllStudents();

        // Delete a student
        System.out.println("\nDeleting Roll Number 3:");
        records.deleteStudentByRollNumber(3);

        // Display all students after deletion
        System.out.println("\nAll Students after Deletion:");
        records.displayAllStudents();
    }
}