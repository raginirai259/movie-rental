package service.impl;

import model.Customer;
import model.MovieRental;
import service.RentalService;

public class RentalServiceImpl implements RentalService {
    private final MovieServiceImpl movieService;

    public RentalServiceImpl() {
        movieService = new MovieServiceImpl();
    }

    @Override
    public String statement(Customer customer) {
        StringBuilder result = calculateRentalAmount(customer);
        result.append("Amount owed is ").append(customer.getTotalRentalAmount()).append("\n");
        result.append("You earned ").append(customer.getTotalBonusPointsEarned()).append(" frequent points\n");
        return result.toString();
    }

    private StringBuilder calculateRentalAmount(Customer customer) {
        double totalRentalAmount = 0;
        int totalBonusPointsEarned = 0;
        StringBuilder result = new StringBuilder("Rental Record for " + customer.getName() + "\n");
        for (MovieRental rental : customer.getRentals()) {
            double rentalAmount = movieService.getRentalAmount(rental);

            result.append("\t").append(movieService.getMovieTitle(rental)).append("\t").append(rentalAmount).append("\n");

            totalRentalAmount += rentalAmount;
            totalBonusPointsEarned += movieService.calculateFrequentRenterPoints(rental);
        }
        customer.setTotalBonusPointsEarned(totalBonusPointsEarned);
        customer.setTotalRentalAmount(totalRentalAmount);

        return result;
    }

}


