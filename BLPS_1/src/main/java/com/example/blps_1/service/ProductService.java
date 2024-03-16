package com.example.blps_1.service;

import com.example.blps_1.dto.ProductDTO;
import com.example.blps_1.entity.Product;
import com.example.blps_1.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product create(ProductDTO dto){
        Product product = Product.builder()
                .name(dto.getName())
                .amount(dto.getAmount())
                .build();
        return productRepository.save(product);
    }

    public List<Product> readAll(){
        return productRepository.findAll();
    }
}
