package doublylinkedlist.librarymanagementSystem;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        DoublyLinkedList library = new DoublyLinkedList();

        // Add some books to the library
        library.addAtEnd("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 101, true);
        library.addAtBeginning("To Kill a Mockingbird", "Harper Lee", "Fiction", 102, true);
        library.addAtPosition("1984", "George Orwell", "Dystopian", 103, false, 2);

        // Display books in forward order
        library.displayForward();

        // Search for a book by title
        System.out.println("\nSearching for '1984':");
        library.searchBook("1984");

        // Update the availability status of a book
        library.updateAvailabilityStatus(103, true);
        System.out.println("\nAfter updating availability status:");
        library.displayForward();

        // Remove a book
        library.removeBookByID(101);
        System.out.println("\nAfter removing a book:");
        library.displayForward();

        // Display books in reverse order
        System.out.println("\nBooks in reverse order:");
        library.displayReverse();

        // Count total books
        System.out.println("\nTotal number of books: " + library.countBooks());
    }
}