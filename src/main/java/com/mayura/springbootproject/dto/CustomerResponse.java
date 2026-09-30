package com.mayura.springbootproject.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record CustomerResponse(

        @Schema(
                description = "Unique ID of the customer",
                example = "1"
        )
        Long id,

        @Schema(
                description = "Full name of the customer",
                example = "John Doe"
        )
        String name,

        @Schema(
                description = "Email address of the customer",
                example = "john.doe@example.com"
        )
        String email,

        @Schema(
                description = "Phone number of the customer",
                example = "9876543210"
        )
        String phone

) {
}