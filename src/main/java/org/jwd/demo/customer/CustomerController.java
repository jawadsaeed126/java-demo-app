package org.jwd.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Usman
 * @created 4/5/2024 - 1:35 AM
 * @project demo
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired private CustomerService service;

	@GetMapping
	public ResponseEntity<List<CustomerDto>> get() {
		return ResponseEntity.ok(service.get());
	}

	@GetMapping("/phoneNumber/{phoneNumber}")
	public ResponseEntity<CustomerDto> get(@RequestParam("phoneNumber") String phoneNumber){
		return ResponseEntity.ok(service.get(phoneNumber));

	}

	@PostMapping()
	public ResponseEntity<CustomerDto> save(@RequestBody CustomerDto customerDto){
		return ResponseEntity.ok(service.save(customerDto));
	}

	@DeleteMapping("/phoneNumber/{phoneNubmer}")
	public ResponseEntity<Void> save(@RequestParam("phoneNumber") String phoneNumber){
		service.delete(phoneNumber);
		return ResponseEntity.ok(null);
	}
}


