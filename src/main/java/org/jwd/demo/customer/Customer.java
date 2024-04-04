package org.jwd.demo.customer;

/**
 * @author Usman
 * @created 4/5/2024 - 1:41 AM
 * @project demo
 */

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
@Entity
@Table(name = "customer")
public class Customer {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
	@Column(name = "firstName") private String firstName;
	@Column(name = "lastName") private String lastName;
	@Column(name = "email") private String email;
	@Column(name = "phoneNumber") private String phoneNumber;
}
