package com.app.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record CustomerRequest(String id, @NotNull(message = "Customer firstName is required") String firstName,
                              @NotNull(message = "Customer lastName is required") String lastName,
                              @Email(message = "email address is invalid") String email, Address address) {

}
