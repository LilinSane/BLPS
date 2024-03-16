package com.example.blps_1.service;

import com.example.blps_1.repository.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartService {

    private CartRepository cartRepository;
}
