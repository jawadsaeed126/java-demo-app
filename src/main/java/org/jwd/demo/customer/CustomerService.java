package org.jwd.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Usman
 * @created 4/5/2024 - 1:40 AM
 * @project demo
 */
@Service
public class CustomerService {

	@Autowired private CustomerRepository repository;
	@Autowired private CustomerMapper mapper;
	public List<CustomerDto> get() {
		return mapper.toDto(repository.findAll());
	}

	public CustomerDto get(String mobileNumber) {
		return mapper.toDto(repository.findByPhoneNumber(mobileNumber).orElseThrow(() -> new IllegalArgumentException("Customer not found")));
	}


	public CustomerDto save(CustomerDto customerDto) {
		Customer customer =  mapper.toEntity(customerDto);
		return mapper.toDto(repository.save(customer));
	}

	public void delete(String phoneNumber) {
		repository.deleteByPhoneNumber(phoneNumber);
	}
}
