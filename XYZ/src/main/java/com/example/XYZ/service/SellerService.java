package com.example.XYZ.service;

import com.example.XYZ.entity.Seller;

public interface SellerService {
    Seller save(Seller seller);

    Seller findSellerById(Long id);
}
