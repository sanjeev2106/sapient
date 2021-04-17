package com.example.XYZ.controller;

import com.example.XYZ.entity.Seller;
import com.example.XYZ.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sellers")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @PostMapping("/")
    public Seller saveSeller(@RequestBody Seller seller) {
        return sellerService.save(seller);
    }

    @GetMapping("/{id}")
    public Seller findSellerById(@PathVariable Long id) {
        return sellerService.findSellerById(id);
    }
}
