package com.kolos.customerservice.data;

import com.kolos.customerservice.data.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
