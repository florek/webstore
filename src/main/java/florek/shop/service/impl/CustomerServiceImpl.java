package florek.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import florek.shop.domain.Customer;
import florek.shop.domain.repository.CustomerRepository;
import florek.shop.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
	return customerRepository.getAllCustomers();
    }
}
