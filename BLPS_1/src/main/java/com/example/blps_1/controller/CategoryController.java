package com.example.blps_1.controller;

import com.example.blps_1.dto.CategoryDTO;
import com.example.blps_1.entity.Product;
import com.example.blps_1.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> get(@RequestBody CategoryDTO categoryDTO){
        return new ResponseEntity<>(productService.readAllByCategory(categoryDTO), HttpStatus.OK);
    }
}
