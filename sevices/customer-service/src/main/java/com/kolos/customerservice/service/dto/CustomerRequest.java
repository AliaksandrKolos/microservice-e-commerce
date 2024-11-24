package com.kolos.customerservice.service.dto;

import com.kolos.customerservice.data.entity.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomerRequest {

    private String id;

    @NotNull(message = "Customer firstname is required")
    private String firstname;

    @NotNull(message = "Customer lastname is required")
    private String lastname;

    @NotNull(message = "Customer email is required")
    @Email(message = "Customer email is not valid email address")
    private String email;

    private Address address;
}
