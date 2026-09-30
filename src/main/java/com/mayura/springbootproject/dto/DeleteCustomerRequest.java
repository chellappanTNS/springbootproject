package com.mayura.springbootproject.dto;


import io.swagger.v3.oas.annotations.media.Schema;

public record DeleteCustomerRequest(

        @Schema(
                description = "ID of the customer to delete",
                example = "1"
        )
        Long id

) {
}