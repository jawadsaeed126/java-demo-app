package org.jwd.demo.customer;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Usman
 * @created 4/5/2024 - 1:48 AM
 * @project demo
 */
@Component
public class CustomerMapper {


	public CustomerDto toDto(Customer customer){
	    CustomerDto customerDto = new CustomerDto();
	    customerDto.setFirstName(customer.getFirstName());
	    customerDto.setLastName(customer.getLastName());
	    customerDto.setEmail(customer.getEmail());
	    customerDto.setPhoneNumber(customer.getPhoneNumber());
	    return customerDto;

	}

	public List<CustomerDto> toDto(List<Customer> all) {
		return all.stream().map(this::toDto).collect(Collectors.toList());
	}

	public Customer toEntity(CustomerDto customerDto) {
	    Customer customer = new Customer();
	    customer.setFirstName(customerDto.getFirstName());
	    customer.setLastName(customerDto.getLastName());
	    customer.setEmail(customerDto.getEmail());
	    customer.setPhoneNumber(customerDto.getPhoneNumber());
	    return customer;


	}
}
