package model;

public class ChildrenMovie extends Movie {

    public ChildrenMovie(String title, double v) {
        super(title,v);
    }

    @Override
    public double calculateBaseRentalAmount(int days) {
        return days * 3;
    }
}