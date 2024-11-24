package com.kolos.customerservice.service;

import com.kolos.customerservice.data.entity.Customer;
import com.kolos.customerservice.service.dto.CustomerRequest;
import com.kolos.customerservice.service.dto.CustomerResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toCustomer(CustomerRequest request);

    CustomerResponse toCustomerResponse(Customer customer);
}
