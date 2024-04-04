package org.jwd.demo.customer;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Usman
 * @created 4/5/2024 - 1:36 AM
 * @project demo
 */
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
public class CustomerDto {


	@JsonProperty("firstName") private String firstName;
	@JsonProperty("lastName") private String lastName;
	@JsonProperty("email") private String email;
	@JsonProperty("phoneNumber") private String phoneNumber;

}