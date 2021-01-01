import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Scratch {
    public static void main(String[] args) {
        ArrayList<Movie> list = new ArrayList<Movie>();
        list.add(new Movie("Force Awakens", 8.3, 2015));
        list.add(new Movie("Star Wars", 8.7, 1977));
        list.add(new Movie("Empire Strikes Back", 8.8, 1980));

        // Uses Comparable interface implementation to sort by year
        System.out.println("Sorted by year:");
        Collections.sort(list);
        for (Movie movie: list)
            System.out.println("   " + movie.getYear() + " " + movie.getName());

        // Sort by rating : (1) Create an object of ratingCompare (2) Call Collections.sort (3) Print Sorted list
        System.out.println("\nSorted by rating:");
        RatingCompare ratingCompare = new RatingCompare();
        //Collections.sort(list, ratingCompare); // alternatively we can use this notation
        list.sort(ratingCompare);
        for (Movie movie: list)
            System.out.println("   " + movie.getRating() + " " + movie.getName());

        // Comparator interface has default methods
        System.out.println("\nSorted using default methods:");
        list.sort(ratingCompare.reversed());
        for (Movie movie: list)
            System.out.println("   " + movie.getRating() + " " + movie.getName());
    }

    // A class 'Movie' that implements Comparable
    static class Movie implements Comparable<Movie>
    {
        private double rating;
        private String name;
        private int year;

        // Used to sort movies by year
        public int compareTo(Movie m)
        {
            return this.year - m.year;
        }

        // Constructor
        public Movie(String nm, double rt, int yr)
        {
            this.name = nm;
            this.rating = rt;
            this.year = yr;
        }

        // Getter methods for accessing private data
        public double getRating() { return rating; }
        public String getName()   { return name; }
        public int getYear()      { return year;  }
    }

    // Class to compare Movies by ratings
    static class RatingCompare implements Comparator<Movie>
    {
        public int compare(Movie m1, Movie m2)
        {
            if (m1.getRating() < m2.getRating()) return -1;
            if (m1.getRating() > m2.getRating()) return 1;
            else return 0;
        }
    }
}