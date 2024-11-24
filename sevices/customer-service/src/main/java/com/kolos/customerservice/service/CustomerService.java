package com.kolos.customerservice.service;

import com.kolos.customerservice.service.dto.CustomerRequest;
import com.kolos.customerservice.service.dto.CustomerResponse;

import java.util.List;

public interface CustomerService {

    String createCustomer(CustomerRequest request);

    void updateCustomer(CustomerRequest request);

    List<CustomerResponse> findAllCustomers();

    Boolean existsById(String customerId);

    CustomerResponse findById(String customerId);

    void deleteCustomer(String customerId);
}
