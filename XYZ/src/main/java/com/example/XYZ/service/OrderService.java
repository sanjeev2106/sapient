package com.example.XYZ.service;

import com.example.XYZ.exception.CustomException;
import com.example.XYZ.vo.CreateOrder;
import com.example.XYZ.vo.OrderVO;

public interface OrderService {
    OrderVO createOrder(CreateOrder createOrder) throws CustomException;

    OrderVO findOrderByOrderId(Long id);
}
