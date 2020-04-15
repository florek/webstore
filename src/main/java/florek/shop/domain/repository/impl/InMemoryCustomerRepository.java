package florek.shop.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import florek.shop.domain.Customer;
import florek.shop.domain.repository.CustomerRepository;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {
    private List<Customer> customers = new ArrayList<Customer>();

    public InMemoryCustomerRepository() {
	customers.add(new Customer(1, "Pawe³ Paw³oski"));
	customers.add(new Customer(2, "Tomasz Przybylski"));
	customers.add(new Customer(3, "Jan Nowak"));

	Customer loyalCustomer = new Customer(4, "Josh Nephew");

	loyalCustomer.setAddress("Manhattan, Nowy Jork");
	loyalCustomer.setNoOfOrdersMade(1231);

	customers.add(loyalCustomer);
    }

    public List<Customer> getAllCustomers() {
	return customers;
    }
}
