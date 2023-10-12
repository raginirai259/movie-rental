package model;

public class RegularMovie extends Movie {
    public RegularMovie(String title, double baseRentalAmount) {
        super(title,baseRentalAmount);
    }

    @Override
    public double calculateBaseRentalAmount(int days) {
        return baseRentalAmount + Math.max(0, days - 2) * 1.5;
    }
}
