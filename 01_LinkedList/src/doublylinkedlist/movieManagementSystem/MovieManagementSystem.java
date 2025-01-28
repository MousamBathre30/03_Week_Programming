package doublylinkedlist.movieManagementSystem;

class MovieManagementSystem {
    private Movie head;
    private Movie tail;

    // Add a movie at the beginning
    public void addMovieAtBeginning(String title, String director, int yearOfRelease, double rating) {
        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // Add a movie at the end
    public void addMovieAtEnd(String title, String director, int yearOfRelease, double rating) {
        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Add a movie at a specific position
    public void addMovieAtPosition(int position, String title, String director, int yearOfRelease, double rating) {
        if (position <= 1) {
            addMovieAtBeginning(title, director, yearOfRelease, rating);
            return;
        }
        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        Movie current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null || current == tail) {
            addMovieAtEnd(title, director, yearOfRelease, rating);
        } else {
            newMovie.next = current.next;
            newMovie.prev = current;
            current.next.prev = newMovie;
            current.next = newMovie;
        }
    }

    // Remove a movie by title
    public void removeMovieByTitle(String title) {
        Movie current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                if (current == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else if (current == tail) {
                    tail = tail.prev;
                    if (tail != null) tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                System.out.println("Movie \"" + title + "\" removed successfully.");
                return;
            }
            current = current.next;
        }
        System.out.println("Movie \"" + title + "\" not found.");
    }

    // Search for a movie by Director or Rating
    public void searchMovieByDirectorOrRating(String director, Double rating) {
        boolean found = false;
        Movie current = head;
        while (current != null) {
            if ((director != null && current.director.equalsIgnoreCase(director)) ||
                    (rating != null && current.rating == rating)) {
                System.out.println("Found: " + current.title + " by " + current.director + " (" + current.yearOfRelease + ") - Rating: " + current.rating);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No movies found matching the criteria.");
    }

    // Display all movies in forward order
    public void displayMoviesForward() {
        if (head == null) {
            System.out.println("No movies in the list.");
            return;
        }
        Movie current = head;
        System.out.println("Movies in forward order:");
        while (current != null) {
            System.out.println(current.title + " | " + current.director + " | " + current.yearOfRelease + " | Rating: " + current.rating);
            current = current.next;
        }
    }

    // Display all movies in reverse order
    public void displayMoviesReverse() {
        if (tail == null) {
            System.out.println("No movies in the list.");
            return;
        }
        Movie current = tail;
        System.out.println("Movies in reverse order:");
        while (current != null) {
            System.out.println(current.title + " | " + current.director + " | " + current.yearOfRelease + " | Rating: " + current.rating);
            current = current.prev;
        }
    }

    // Update a movie's rating based on title
    public void updateMovieRating(String title, double newRating) {
        Movie current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = newRating;
                System.out.println("Rating updated for \"" + title + "\" to " + newRating);
                return;
            }
            current = current.next;
        }
        System.out.println("Movie \"" + title + "\" not found.");
    }
}