package com.example.XYZ.controller;

import com.example.XYZ.exception.CustomException;
import com.example.XYZ.service.OrderService;
import com.example.XYZ.vo.CreateOrder;
import com.example.XYZ.vo.ErrorResponse;
import com.example.XYZ.vo.OrderVO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    OrderService orderService;

    @PostMapping("/create")
    public Object createOrder(@RequestBody CreateOrder createOrder) {
        try {
            return orderService.createOrder(createOrder);
        } catch (CustomException e) {
            return new ErrorResponse(e.getStatusCode(), e.getStatus(), e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public OrderVO findOrderByOrderId(@PathVariable Long id) {
        return orderService.findOrderByOrderId(id);
    }
}
