package model;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<MovieRental> rentals = new ArrayList<>();

    private double totalRentalAmount = 0;

    private int totalBonusPointsEarned = 0;

    public Customer(String name, List<MovieRental> rentals) {
        this.name = name;
        this.rentals = rentals;
    }

    public Customer() {

    }
    public String getName() {
        return name;
    }

    public List<MovieRental> getRentals() {
        return rentals;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addRentals(MovieRental rental) {
        rentals.add(rental);
    }

    public double getTotalRentalAmount() {
        return totalRentalAmount;
    }

    public int getTotalBonusPointsEarned() {
        return totalBonusPointsEarned;
    }

    public void setTotalRentalAmount(double totalRentalAmount) {
        this.totalRentalAmount = totalRentalAmount;
    }

    public void setTotalBonusPointsEarned(int totalBonusPointsEarned) {
        this.totalBonusPointsEarned = totalBonusPointsEarned;
    }
}
