package com.example.blps_1.service;

import com.example.blps_1.dto.VendorDTO;
import com.example.blps_1.entity.Vendor;
import com.example.blps_1.repository.VendorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VendorService {

    private VendorRepository vendorRepository;

    public Vendor create(VendorDTO vendorDTO){
        Vendor vendor = Vendor.builder()
                .name(vendorDTO.getName())
                .build();
        return vendorRepository.save(vendor);
    }

    public Vendor readById(Long id){
        return vendorRepository.findById(id).orElseThrow();
    }
}
