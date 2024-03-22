package com.example.blps_1.service;

import com.example.blps_1.dto.ClientDTO;
import com.example.blps_1.dto.ProductDTO;
import com.example.blps_1.entity.Client;
import com.example.blps_1.entity.Product;
import com.example.blps_1.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {

    private ClientRepository clientRepository;
    private ProductService productService;

    public Client create(ClientDTO clientDTO){
       return clientRepository.save(Client.builder()
                .name(clientDTO.getName())
                .login(clientDTO.getLogin())
                .password(clientDTO.getPassword())
                .build());
    }

    public Client readById(Long id){
        return clientRepository.findById(id).orElseThrow();
    }

    public void update(Client client){
        clientRepository.save(client);
    }

    public void delete (Long id) {
        clientRepository.delete(readById(id));
    }

    public List<Client> readAll() {
        return clientRepository.findAll();
    }

    public List<Client> readAllByProductId(ProductDTO productDTO){
        Product product = productService.readByName(productDTO);
        return clientRepository.findByCartId(product.getId());
    }

    //Добавление продукта(ов) в корзину
    public Product add(Long clientId, ProductDTO productDTO){
        Client client = clientRepository.findById(clientId).orElseThrow();
        Product product = productService.readByName(productDTO);
        for (int i = 0; i < productDTO.getAmount(); i++){
            client.getCart().add(product);
        }
        clientRepository.save(client);
        return product;
    }
}
