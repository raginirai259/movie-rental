package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerBuilder {

    public static final String NAME = "Ragini";
    private String name = NAME;
    private final List<MovieRental> rentals = new ArrayList<>();

    public Customer build() {
        Customer result = new Customer();
        result.setName(name);
        for (MovieRental rental : rentals) {
            result.addRentals(rental);
        }
        return result;
    }

    public CustomerBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CustomerBuilder withRentals(MovieRental... rentals) {
        Collections.addAll(this.rentals, rentals);
        return this;
    }
}

