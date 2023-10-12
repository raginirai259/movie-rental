package service;

import model.Customer;

public interface RentalService {

    String generateRentalStatement(Customer customer);
}
