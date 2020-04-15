package florek.shop.domain.repository;

import java.util.List;

import florek.shop.domain.Customer;

public interface CustomerRepository {
    List<Customer> getAllCustomers();
}
