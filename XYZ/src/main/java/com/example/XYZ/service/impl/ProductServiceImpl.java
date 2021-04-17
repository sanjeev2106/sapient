package com.example.XYZ.service.impl;

import com.example.XYZ.entity.Product;
import com.example.XYZ.enums.Size;
import com.example.XYZ.repository.ProductRepository;
import com.example.XYZ.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.findProductById(id);
    }

    @Override
    public Product updateQuantity(Product product) {
        synchronized (this) {
            Product p = findProductById(product.getId());
            p.setQuantity(p.getQuantity() + product.getQuantity());
            productRepository.save(p);
            return p;
        }
    }

    @Override
    public Map<String, List<Product>> groupByBrand() {
        //return productRepository.groupByBrand();
        List<Product> products = productRepository.findAll();
        Map<String, List<Product>> productsByBrand = products.stream()
                .collect(groupingBy(Product::getBrandName));

        return productsByBrand;
    }

    @Override
    public Map<Size, List<Product>> groupBySize() {
        //return productRepository.groupBySize();
        List<Product> products = productRepository.findAll();
        return products.stream()
                .collect(groupingBy(Product::getPSize));
    }

    @Override
    public Map<String, List<Product>> groupByColor() {
        //return productRepository.groupByColor();
        List<Product> products = productRepository.findAll();
        return products.stream()
                .collect(groupingBy(Product::getColor));
    }

    @Override
    public Map<BigDecimal, List<Product>> groupByPrice() {
        //return productRepository.groupByPrice();
        List<Product> products = productRepository.findAll();
        return products.stream()
                .collect(groupingBy(Product::getPrice));
    }

    @Override
    public Map<Long, Long> groupBySeller() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .collect(Collectors.groupingBy(Product::getSellerId, Collectors.counting()));
    }
}
