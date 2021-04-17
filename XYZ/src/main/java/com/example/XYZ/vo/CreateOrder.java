package com.example.XYZ.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrder {
    private Long productId;
    private Long customerId;
    private int quantity;
}
