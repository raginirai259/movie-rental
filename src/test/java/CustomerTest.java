import model.Customer;
import model.CustomerBuilder;
import model.MovieRental;
import org.junit.Test;
import service.impl.RentalServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CustomerTest {


    private final RentalServiceImpl rentalService;

    public CustomerTest() {
        rentalService = new RentalServiceImpl();
    }

    @Test
    public void testCustomer() {
        Customer c = new CustomerBuilder().build();
        assertNotNull(c);
    }


    @Test
    public void testGetName() {
        Customer c = new CustomerBuilder().withName("David").build();
        assertEquals("David", c.getName());
    }

    @Test
    public void statementForManyMovies() {
        MovieRental rental1 = new MovieRental("F001", 6); // 6 day rental
        MovieRental rental2 = new MovieRental("F002", 2); // 2 day rental
        MovieRental rental3 = new MovieRental("F003", 8); // 8 day rental
        Customer customer1
                = new CustomerBuilder()
                .withName("David")
                .withRentals(rental1, rental2, rental3)
                .build();
        String expected = """
                Rental Record for David
                \tYou've Got Mail\t8.0
                \tMatrix\t2.0
                \tCars\t24.0
                Amount owed is 34.0
                You earned 3 frequent points
                """;
        String statement = rentalService.statement(customer1);
        assertEquals(expected, statement);
    }


}
