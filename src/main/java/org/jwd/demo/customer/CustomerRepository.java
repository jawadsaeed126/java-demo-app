package org.jwd.demo.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Usman
 * @created 4/5/2024 - 1:46 AM
 * @project demo
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Optional<Customer> findByPhoneNumber(String phoneNumber);
	void deleteByPhoneNumber(String phoneNumber);
}
