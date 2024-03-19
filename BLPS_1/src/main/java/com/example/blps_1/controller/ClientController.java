package com.example.blps_1.controller;

import com.example.blps_1.dto.ClientDTO;
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
@RequestMapping("/client")
@AllArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final ProductService productService;
    private final NotificationService notificationService;

    @PostMapping
    public ResponseEntity<Client> add(@RequestBody ClientDTO clientDTO){
        return new ResponseEntity<>(clientService.create(clientDTO), HttpStatus.OK);
    }

    @PostMapping("/cart")
    public ResponseEntity<Product> add(@RequestParam Long clientId, @RequestBody ProductDTO productDTO){

        //Проверка наличия запрашиваемого количества продкутов на складе
        if(productDTO.getAmount() > productService.readByName(productDTO).getAmount()){
            notificationService.setNotificationStatus(clientId, productDTO);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(clientService.add(clientId, productDTO), HttpStatus.OK);
    }

}
