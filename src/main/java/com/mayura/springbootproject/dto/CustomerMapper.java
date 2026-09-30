package com.mayura.springbootproject.dto;

import com.mayura.springbootproject.entity.Customer;

public class CustomerMapper {

    public static CustomerResponse toResponse(Customer customer) {

        return new CustomerResponse(
                customer.getId(),
                customer.getName(),
                customer.getEmail(),
                customer.getPhone()
        );
    }
}