package com.kolos.customerservice.service.dto;

import com.kolos.customerservice.data.entity.Address;
import lombok.Data;

@Data
public class CustomerResponse {

    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private Address address;
}
