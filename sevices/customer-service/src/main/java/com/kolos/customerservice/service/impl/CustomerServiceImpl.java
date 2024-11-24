package com.kolos.customerservice.service.impl;

import com.kolos.customerservice.data.entity.Customer;
import com.kolos.customerservice.service.CustomerMapper;
import com.kolos.customerservice.data.CustomerRepository;
import com.kolos.customerservice.service.dto.CustomerRequest;
import com.kolos.customerservice.service.dto.CustomerResponse;
import com.kolos.customerservice.web.exception.CustomerNotFoundException;
import com.kolos.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;


    @Override
    public String createCustomer(CustomerRequest request) {
        var customer = customerRepository.save(customerMapper.toCustomer(request));
        return customer.getId();
    }

    @Override
    public void updateCustomer(CustomerRequest request) {
        var customer = customerRepository.findById(request.getId())
                .orElseThrow(() -> new CustomerNotFoundException(
                        String.format("Cannot update customer:: No customer found with the provided ID: %s", request.getId())
                ));
        mergerCustomer(customer, request);
        customerRepository.save(customer);
    }

    @Override
    public List<CustomerResponse> findAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toCustomerResponse)
                .toList();
    }

    @Override
    public Boolean existsById(String customerId) {
        return customerRepository.findById(customerId)
                .isPresent();
    }

    @Override
    public CustomerResponse findById(String customerId) {
        return customerRepository.findById(customerId)
                .map(customerMapper::toCustomerResponse)
                .orElseThrow(() -> new CustomerNotFoundException(String.format("No customer found with the provided ID: %s", customerId)));
    }

    @Override
    public void deleteCustomer(String customerId) {
        customerRepository.deleteById(customerId);
    }




    private void mergerCustomer(Customer customer, CustomerRequest request) {
        if (StringUtils.isNotBlank(request.getFirstname())) {
            customer.setFirstname(request.getFirstname());
        }
        if (StringUtils.isNotBlank(request.getLastname())) {
            customer.setLastname(request.getLastname());
        }
        if (StringUtils.isNotBlank(request.getEmail())) {
            customer.setEmail(request.getEmail());
        }
        if (request.getAddress() != null) {
            customer.setAddress(request.getAddress());
        }
    }
}
