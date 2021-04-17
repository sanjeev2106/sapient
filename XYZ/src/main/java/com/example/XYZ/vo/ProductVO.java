package com.example.XYZ.vo;

import com.example.XYZ.entity.Seller;
import com.example.XYZ.enums.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductVO {
    private Long id;
    private String category;
    private String brandName;
    private BigDecimal price;
    private String color;
    private Size size;
    private Seller seller;
    private int quantity;

    public ProductVO setId(Long id) {
        this.id = id;
        return this;
    }

    public ProductVO setCategory(String category) {
        this.category = category;
        return this;
    }

    public ProductVO setBrandName(String brandName) {
        this.brandName = brandName;
        return this;
    }

    public ProductVO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ProductVO setColor(String color) {
        this.color = color;
        return this;
    }

    public ProductVO setSize(Size size) {
        this.size = size;
        return this;
    }

    public ProductVO setSeller(Seller seller) {
        this.seller = seller;
        return this;
    }

    public ProductVO setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
}
