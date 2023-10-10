package service;

import model.MovieRental;

public interface MovieService {

    double getRentalAmount(MovieRental rental);

    String getMovieTitle(MovieRental rental);

    int calculateFrequentRenterPoints(MovieRental rental);
}
