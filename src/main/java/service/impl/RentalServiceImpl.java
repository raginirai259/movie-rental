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
    public String generateRentalStatement(Customer customer) {
        StringBuilder result = buildRentalStatement(customer);
        addTotalRentalAmountToStatement(result, customer);
        addTotalBonusPointsToStatement(result, customer);
        return result.toString();
    }

    private void addTotalRentalAmountToStatement(StringBuilder result, Customer customer) {
        result.append("Amount owed is ").append(customer.getTotalRentalAmount()).append("\n");
    }

    private void addTotalBonusPointsToStatement(StringBuilder result, Customer customer) {
        result.append("You earned ").append(customer.getTotalBonusPointsEarned()).append(" frequent points\n");
    }

    private StringBuilder buildRentalStatement(Customer customer) {
        double totalRentalAmount = 0;
        int totalBonusPointsEarned = 0;
        StringBuilder result = new StringBuilder("Rental Record for " + customer.getName() + "\n");

        for (MovieRental rental : customer.getRentals()) {
            double rentalAmount = movieService.getRentalAmount(rental);
            String movieTitle = movieService.getMovieTitle(rental);

            result.append("\t").append(movieTitle).append("\t").append(rentalAmount).append("\n");

            totalRentalAmount += rentalAmount;
            totalBonusPointsEarned += movieService.calculateFrequentRenterPoints(rental);
        }

        customer.setTotalBonusPointsEarned(totalBonusPointsEarned);
        customer.setTotalRentalAmount(totalRentalAmount);

        return result;
    }


}


