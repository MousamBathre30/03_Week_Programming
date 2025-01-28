package doublylinkedlist.librarymanagementSystem;

class DoublyLinkedList {
    private Book head;
    private Book tail;

    // Add a new book at the beginning
    public void addAtBeginning(String title, String author, String genre, int bookID, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookID, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    // Add a new book at the end
    public void addAtEnd(String title, String author, String genre, int bookID, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookID, isAvailable);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    // Add a new book at a specific position
    public void addAtPosition(String title, String author, String genre, int bookID, boolean isAvailable, int position) {
        if (position < 1) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            addAtBeginning(title, author, genre, bookID, isAvailable);
            return;
        }
        Book newBook = new Book(title, author, genre, bookID, isAvailable);
        Book current = head;
        int count = 1;

        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }
        if (current == null) {
            System.out.println("Position out of range.");
        } else {
            newBook.next = current.next;
            newBook.prev = current;
            if (current.next != null) {
                current.next.prev = newBook;
            } else {
                tail = newBook;
            }
            current.next = newBook;
        }
    }

    // Remove a book by Book ID
    public void removeBookByID(int bookID) {
        if (head == null) {
            System.out.println("The library is empty.");
            return;
        }
        Book current = head;
        while (current != null && current.bookID != bookID) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Book not found.");
            return;
        }
        if (current == head) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null; // If the list becomes empty
            }
        } else if (current == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        System.out.println("Book with ID " + bookID + " has been removed.");
    }

    // Search for a book by Title or Author
    public void searchBook(String titleOrAuthor) {
        Book current = head;
        boolean found = false;
        while (current != null) {
            if (current.title.equalsIgnoreCase(titleOrAuthor) || current.author.equalsIgnoreCase(titleOrAuthor)) {
                System.out.println("Book Found: Title: " + current.title + ", Author: " + current.author +
                        ", Genre: " + current.genre + ", ID: " + current.bookID + ", Available: " + current.isAvailable);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No book found with the given title or author.");
        }
    }

    // Update the availability status of a book
    public void updateAvailabilityStatus(int bookID, boolean newStatus) {
        Book current = head;
        while (current != null) {
            if (current.bookID == bookID) {
                current.isAvailable = newStatus;
                System.out.println("Availability status of book with ID " + bookID + " has been updated.");
                return;
            }
            current = current.next;
        }
        System.out.println("Book not found.");
    }

    // Display all books in forward order
    public void displayForward() {
        Book current = head;
        System.out.println("Books in forward order:");
        while (current != null) {
            displayBookDetails(current);
            current = current.next;
        }
    }

    // Display all books in reverse order
    public void displayReverse() {
        Book current = tail;
        System.out.println("Books in reverse order:");
        while (current != null) {
            displayBookDetails(current);
            current = current.prev;
        }
    }

    // Count the total number of books
    public int countBooks() {
        int count = 0;
        Book current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Helper method to display book details
    private void displayBookDetails(Book book) {
        System.out.println("Title: " + book.title + ", Author: " + book.author + ", Genre: " + book.genre +
                ", ID: " + book.bookID + ", Available: " + book.isAvailable);
    }
}