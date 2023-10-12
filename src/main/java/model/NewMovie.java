package model;

public class NewMovie extends Movie {
    public NewMovie(String title, double baseRentalAmount) {
        super(title,baseRentalAmount);
    }

    @Override
    public double calculateBaseRentalAmount(int days) {
        return baseRentalAmount + Math.max(0, days - 3) * 1.5;
    }
}
