package com.kolos.orderservice.web.client;

import lombok.Data;

@Data
public class CustomerResponse {

    private String id;
    private String firstname;
    private String lastname;
    private String email;
}
