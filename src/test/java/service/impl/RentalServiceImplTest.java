package service.impl;

import model.Customer;
import model.MovieRental;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class RentalServiceImplTest {

    private final RentalServiceImpl rentalService;

    public RentalServiceImplTest() {
        rentalService = new RentalServiceImpl();
    }

    @Test
    public void testStatementWithNoRentals() {
        Customer customer = new Customer("John Doe", List.of());
        String expected = "Rental Record for John Doe\nAmount owed is 0.0\nYou earned 0 frequent points\n";
        String result = rentalService.generateRentalStatement(customer);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testStatementWithSingleRental() {
        Customer customer = new Customer("Alice", List.of(new MovieRental("F001", 3)));
        String expected = "Rental Record for Alice\n\tYou've Got Mail\t3.5\nAmount owed is 3.5\nYou earned 1 frequent points\n";
        String result = rentalService.generateRentalStatement(customer);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testStatementWithMultipleRentals() {
        Customer customer = new Customer("C. U. Stomer", List.of(new MovieRental("F001", 3), new MovieRental("F002", 1)));
        String expected = "Rental Record for C. U. Stomer\n\tYou've Got Mail\t3.5\n\tMatrix\t2.0\nAmount owed is 5.5\nYou earned 2 frequent points\n";
        String result = rentalService.generateRentalStatement(customer);
        Assert.assertEquals(expected, result);
    }
}