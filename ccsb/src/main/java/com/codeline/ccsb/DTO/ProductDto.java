package com.codeline.ccsb.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    @NotBlank(message = "Name must not be empty")
    private String name;

    @NotBlank(message = "Category must not be empty")
    private String category;

    @Positive(message = "Price must be greater than zero")
    private Double price;

    @Min(value = 0, message = "Quantity must not be negative")
    private Integer availableQuantity;
}
