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
    private final CategoryService categoryService;
    private final VendorService vendorService;

    public Product create(ProductDTO productDTO){
        Product product = Product.builder()
                .name(productDTO.getName())
                .amount(productDTO.getAmount())
                .category(categoryService.readById(productDTO.getCategoryId()))
                .vendor(vendorService.readById(productDTO.getVendorId()))
                .build();
        return productRepository.save(product);
    }

    public Product readByName(ProductDTO productDTO){
        return productRepository.findByName(productDTO.getName());
    }

    public Product update(Product product) {
        return productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.delete(readById(id));
    }

    public List<Product> readAll(){
        return productRepository.findAll();
    }

    public Product addAmount(ProductDTO productDTO){
        Product product = readByName(productDTO);
        product.setAmount(product.getAmount() + productDTO.getAmount());
        return productRepository.save(product);
    }

    public Product readById(Long id){
        return productRepository.findById(id).orElseThrow();
    }
}
