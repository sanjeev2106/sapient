package com.example.XYZ.service;

import com.example.XYZ.entity.Product;
import com.example.XYZ.enums.Size;
import com.example.XYZ.exception.CustomException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ProductService {
    Product save(Product product);

    Product findProductById(Long id);

    Product updateQuantity(Product product) throws CustomException;

    Product updateProductQuantity(Long id, int quantity, char operation) throws CustomException;

    Map<String, List<Product>> groupByBrand();

    Map<Size, List<Product>> groupBySize();

    Map<String, List<Product>> groupByColor();

    Map<BigDecimal, List<Product>> groupByPrice();

    Map<Long, Long> groupBySeller();
}
