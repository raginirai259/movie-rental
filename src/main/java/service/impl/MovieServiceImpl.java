package service.impl;

import model.Movie;
import model.MovieRental;
import service.MovieService;
import utility.MovieUtility;

import java.util.Map;

public class MovieServiceImpl implements MovieService {

    Map<String, Movie> movies = MovieUtility.getAllMovies();

    @Override
    public double getRentalAmount(MovieRental rental) {
        return MovieUtility.calculateAmount(rental, movies.get(rental.getMovieId()));
    }

    @Override
    public String getMovieTitle(MovieRental rental) {
        return movies.get(rental.getMovieId()).getTitle();
    }

    @Override
    public int calculateFrequentRenterPoints(MovieRental rental) {
        return MovieUtility.calculateFrequentRenterPoints(rental, movies.get(rental.getMovieId()));
    }
}
