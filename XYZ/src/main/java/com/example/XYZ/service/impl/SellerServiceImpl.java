package com.example.XYZ.service.impl;

import com.example.XYZ.entity.Seller;
import com.example.XYZ.repository.SellerRepository;
import com.example.XYZ.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public Seller save(Seller seller) {
        return sellerRepository.save(seller);
    }

    @Override
    public Seller findSellerById(Long id) {
        return sellerRepository.findSellerById(id);
    }
}
