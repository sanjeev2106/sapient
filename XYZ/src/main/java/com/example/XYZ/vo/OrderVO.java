package com.example.XYZ.vo;

import com.example.XYZ.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVO {
    private Long orderId;
    private ProductVO product;
    private Customer customer;
    private Date orderDate;
    private BigDecimal price;

    public OrderVO setOrderId(Long orderId) {
        this.orderId = orderId;
        return this;
    }

    public OrderVO setProduct(ProductVO product) {
        this.product = product;
        return this;
    }

    public OrderVO setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public OrderVO setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public OrderVO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
