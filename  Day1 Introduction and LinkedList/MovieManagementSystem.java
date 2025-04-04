class Movie {
    String title;
    String director;
    int year;
    double rating;

    Movie next;
    Movie prev;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieList {
    private Movie head;
    private Movie tail;

    // Add at beginning
    public void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // Add at end
    public void addAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Add at a specific position (1-based index)
    public void addAtPosition(int position, String title, String director, int year, double rating) {
        if (position <= 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        Movie current = head;
        int count = 1;

        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        if (current == null || current.next == null) {
            addAtEnd(title, director, year, rating);
        } else {
            Movie newMovie = new Movie(title, director, year, rating);
            newMovie.next = current.next;
            newMovie.prev = current;
            current.next.prev = newMovie;
            current.next = newMovie;
        }
    }

    // Remove by title
    public void removeByTitle(String title) {
        Movie current = head;

        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                if (current == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                    else tail = null;
                } else if (current == tail) {
                    tail = tail.prev;
                    if (tail != null) tail.next = null;
                    else head = null;
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

    // Search by director
    public void searchByDirector(String director) {
        Movie current = head;
        boolean found = false;
        while (current != null) {
            if (current.director.equalsIgnoreCase(director)) {
                printMovie(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No movies found by director: " + director);
    }

    // Search by rating
    public void searchByRating(double rating) {
        Movie current = head;
        boolean found = false;
        while (current != null) {
            if (current.rating == rating) {
                printMovie(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No movies found with rating: " + rating);
    }

    // Update rating by title
    public void updateRating(String title, double newRating) {
        Movie current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = newRating;
                System.out.println("Rating updated for \"" + title + "\".");
                return;
            }
            current = current.next;
        }
        System.out.println("Movie \"" + title + "\" not found.");
    }

    // Display forward
    public void displayForward() {
        if (head == null) {
            System.out.println("No movies to display.");
            return;
        }
        System.out.println("Movies (Forward):");
        Movie current = head;
        while (current != null) {
            printMovie(current);
            current = current.next;
        }
    }

    // Display reverse
    public void displayReverse() {
        if (tail == null) {
            System.out.println("No movies to display.");
            return;
        }
        System.out.println("Movies (Reverse):");
        Movie current = tail;
        while (current != null) {
            printMovie(current);
            current = current.prev;
        }
    }

    private void printMovie(Movie movie) {
        System.out.println("Title: " + movie.title +
                ", Director: " + movie.director +
                ", Year: " + movie.year +
                ", Rating: " + movie.rating);
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieList list = new MovieList();

        list.addAtBeginning("Inception", "Christopher Nolan", 2010, 8.8);
        list.addAtEnd("Interstellar", "Christopher Nolan", 2014, 8.6);
        list.addAtPosition(2, "The Dark Knight", "Christopher Nolan", 2008, 9.0);
        list.addAtEnd("The Matrix", "Wachowskis", 1999, 8.7);

        list.displayForward();
        list.displayReverse();

        list.searchByDirector("Christopher Nolan");
        list.searchByRating(8.7);

        list.updateRating("The Matrix", 9.1);
        list.displayForward();

        list.removeByTitle("Inception");
        list.displayForward();
    }
}
