package doublylinkedlist.movieManagementSystem;

public class Main {
    public static void main(String[] args) {
        MovieManagementSystem mms = new MovieManagementSystem();

        // Add movies
        mms.addMovieAtEnd("Inception", "Christopher Nolan", 2010, 9.0);
        mms.addMovieAtEnd("Interstellar", "Christopher Nolan", 2014, 8.6);
        mms.addMovieAtBeginning("The Dark Knight", "Christopher Nolan", 2008, 9.1);
        mms.addMovieAtPosition(2, "Tenet", "Christopher Nolan", 2020, 7.5);

        // Display movies
        System.out.println("\n--- Display Movies Forward ---");
        mms.displayMoviesForward();

        System.out.println("\n--- Display Movies Reverse ---");
        mms.displayMoviesReverse();

        // Search for movies
        System.out.println("\n--- Search Movies by Director: Christopher Nolan ---");
        mms.searchMovieByDirectorOrRating("Christopher Nolan", null);

        System.out.println("\n--- Search Movies by Rating: 8.6 ---");
        mms.searchMovieByDirectorOrRating(null, 8.6);

        // Update a movie's rating
        System.out.println("\n--- Update Movie Rating ---");
        mms.updateMovieRating("Tenet", 8.0);

        // Remove a movie
        System.out.println("\n--- Remove Movie ---");
        mms.removeMovieByTitle("The Dark Knight");

        // Display movies again
        System.out.println("\n--- Display Movies After Updates ---");
        mms.displayMoviesForward();
    }
}