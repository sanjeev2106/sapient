package com.example.XYZ.controller;

import com.example.XYZ.entity.Product;
import com.example.XYZ.enums.Size;
import com.example.XYZ.exception.CustomException;
import com.example.XYZ.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RequestMapping("/products")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/")
    public Product saveProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable Long id) {
        return productService.findProductById(id);
    }

    @PostMapping("/addQuantity")
    public Product updateQuantity(@RequestBody Product product) throws CustomException {
        return productService.updateQuantity(product);
    }

    @GetMapping("/groupByBrand")
    public Map<String, List<Product>> getAllProductGroupByBrand() {
        return productService.groupByBrand();
    }

    @GetMapping("/groupByPrice")
    public Map<BigDecimal, List<Product>> getAllProductGroupByPrice() {
        return productService.groupByPrice();
    }

    @GetMapping("/groupByColor")
    public Map<String, List<Product>> getAllProductGroupByColor() {
        return productService.groupByColor();
    }

    @GetMapping("/groupBySize")
    public Map<Size, List<Product>> getAllProductGroupBySize() {
        return productService.groupBySize();
    }

    @GetMapping("/groupBySeller")
    public Map<Long, Long> getAllProductGroupBySeller() {
        return productService.groupBySeller();
    }
}
