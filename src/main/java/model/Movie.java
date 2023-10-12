package model;

public abstract class Movie {

    protected String title;
    protected double baseRentalAmount;

    protected Movie(String title, double baseRentalAmount) {
        this.title=title;
        this.baseRentalAmount = baseRentalAmount;
    }

    public abstract double calculateBaseRentalAmount(int days);

    public double calculateRentalAmount(double baseAmount) {
        return baseAmount;
    }

    public String getTitle() {
        return title;
    }
}