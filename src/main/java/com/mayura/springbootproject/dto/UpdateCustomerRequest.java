package com.mayura.springbootproject.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UpdateCustomerRequest(

        @Schema(
                description = "Full name of the customer",
                example = "John Smith"
        )
        @NotBlank
        String name,

        @Schema(
                description = "Email address of the customer",
                example = "john.smith@example.com"
        )
        @NotBlank
        @Email
        String email,

        @Schema(
                description = "Phone number of the customer",
                example = "9876543210"
        )
        @NotBlank
        String phone

) {
}