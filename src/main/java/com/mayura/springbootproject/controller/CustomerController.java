package com.mayura.springbootproject.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mayura.springbootproject.dto.CreateCustomerRequest;
import com.mayura.springbootproject.dto.CustomerMapper;
import com.mayura.springbootproject.dto.CustomerResponse;
import com.mayura.springbootproject.entity.Customer;
import com.mayura.springbootproject.service.CustomerService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import jakarta.validation.Valid;

@RestController
@Tag(name = "Customers", description = "Customer management APIs")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {

        this.customerService = customerService;

    }

    @Operation(
            summary = "Create a customer",
            description = "Creates a new customer"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Customer created successfully"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid customer data"
            )
    })
    @PostMapping("/customers")
    public CustomerResponse createCustomer(
            @Valid @RequestBody CreateCustomerRequest request) {

        Customer customer = customerService.createCustomer(request);

        return CustomerMapper.toResponse(customer);
    }

    @Operation(
            summary = "Get all customers",
            description = "Returns a paginated list of customers"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Customers retrieved successfully"
            )
    })
    @GetMapping("/customers")
    public Page<CustomerResponse> getCustomers(Pageable pageable) {

        return customerService.getCustomers(pageable);
    }

    @Operation(
            summary = "Search customers",
            description = "Searches customers by name"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Search completed successfully"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid search request"
            )
    })
    @GetMapping("/customers/search")
    public Page<CustomerResponse> searchCustomers(
            @RequestParam String name,
            Pageable pageable) {

        return customerService.searchCustomers(name, pageable);
    }

}