package doublylinkedlist.librarymanagementSystem;

class Book {
    String title;
    String author;
    String genre;
    int bookID;
    boolean isAvailable; // Availability status: true = available, false = not available
    Book next;
    Book prev;

    // Constructor to initialize book attributes
    public Book(String title, String author, String genre, int bookID, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookID = bookID;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}