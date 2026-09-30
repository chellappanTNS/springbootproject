package com.mayura.springbootproject.service;

import org.springframework.stereotype.Service;

import com.mayura.springbootproject.dto.CreateCustomerRequest;
import com.mayura.springbootproject.entity.Customer;
import com.mayura.springbootproject.repository.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mayura.springbootproject.dto.CustomerMapper;
import com.mayura.springbootproject.dto.CustomerResponse;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(CreateCustomerRequest request) {

        Customer customer = new Customer();

        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setPhone(request.phone());

        return customerRepository.save(customer);
    }
    public Page<CustomerResponse> getCustomers(Pageable pageable) {

        Page<Customer> customers = customerRepository.findAll(pageable);

        return customers.map(CustomerMapper::toResponse);
    }
    
    public Page<CustomerResponse> searchCustomers(
            String name,
            Pageable pageable) {

        Page<Customer> customers =
                customerRepository.findByNameContainingIgnoreCase(name, pageable);

        return customers.map(CustomerMapper::toResponse);
    }
}