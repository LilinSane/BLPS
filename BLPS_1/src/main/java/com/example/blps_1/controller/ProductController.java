package com.example.blps_1.controller;

import com.example.blps_1.dto.ProductDTO;
import com.example.blps_1.entity.Client;
import com.example.blps_1.entity.Product;
import com.example.blps_1.service.ClientService;
import com.example.blps_1.service.NotificationService;
import com.example.blps_1.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ClientService clientService;
    private final NotificationService notificationService;

    @PostMapping
    public ResponseEntity<Product> add(@RequestBody ProductDTO productDTO){
        Product product = productService.addAmount(productDTO);
        for (Client client : clientService.readAllByProductId(productDTO)){
            notificationService.sendNotification(client.getId(), "Notification", "Your product is available now");
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
