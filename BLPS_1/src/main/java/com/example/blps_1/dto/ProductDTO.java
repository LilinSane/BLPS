package com.example.blps_1.dto;

import lombok.Data;

@Data
public class ProductDTO {

    private String name;
    private Integer amount;
    private Long categoryId;
    private Long vendorId;
}
