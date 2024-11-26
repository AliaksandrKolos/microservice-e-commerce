package com.kolos.paymentservice.service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class Customer {

    private String id;
    @NotNull(message = "Firstname is required")
    private String firstname;
    @NotNull(message = "Lastname is required")
    private String lastname;
    @NotNull(message = "email is required")
    @Email(message = "The customer is not correctly")
    private String email;
}
