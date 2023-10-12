package utility;

import constant.MovieType;
import model.*;

import java.util.HashMap;
import java.util.Map;

public class MovieUtility {


    public static Map<String, Movie> getAllMovies() {
        Map<String, Movie> movies = new HashMap<>();
        movies.put("F001", initializeMovies("You've Got Mail", MovieType.REGULAR));
        movies.put("F002", initializeMovies("Matrix", MovieType.REGULAR));
        movies.put("F003", initializeMovies("Cars", MovieType.CHILDREN));
        movies.put("F004", initializeMovies("Fast & Furious X", MovieType.NEW));
        return movies;
    }

    private static Movie initializeMovies(String title, MovieType movieType) {
        Movie movie = null;
        switch (movieType) {
            case NEW -> movie = new NewMovie(title, 0);
            case REGULAR -> movie = new RegularMovie(title, 2);
            case CHILDREN -> movie = new ChildrenMovie(title, 1.5);
        }
        return movie;
    }

    public static double calculateAmount(MovieRental rental, Movie movie) {
        double baseRentalAmount = movie.calculateBaseRentalAmount(rental.getDays());
        return movie.calculateRentalAmount(baseRentalAmount);
    }


    public static int calculateFrequentRenterPoints(MovieRental rental, Movie movie) {
        int bonusPoints = 1;
        if (movie instanceof NewMovie && (rental.getDays() > 2)) {
            bonusPoints++;
        }
        return bonusPoints;

    }
}
