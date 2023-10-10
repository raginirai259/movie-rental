package model;

public class Movie {
    private String title;
    private double baseRentalAmount;

    public Movie(String title, double baseRentalAmount) {

        this.title = title;
        this.baseRentalAmount = baseRentalAmount;
    }

    public String getTitle() {
        return title;
    }

    public double getBaseRentalAmount() {
        return baseRentalAmount;
    }
}
