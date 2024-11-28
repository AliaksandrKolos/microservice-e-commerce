package com.kolos.orderservice.web.client.customer;

import lombok.Data;

import java.io.Serializable;

@Data
public class CustomerResponse implements Serializable {

    private String id;
    private String firstname;
    private String lastname;
    private String email;
}
