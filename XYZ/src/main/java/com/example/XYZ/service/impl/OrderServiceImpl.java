package com.example.XYZ.service.impl;

import com.example.XYZ.entity.Customer;
import com.example.XYZ.entity.Order;
import com.example.XYZ.entity.Product;
import com.example.XYZ.entity.Seller;
import com.example.XYZ.exception.CustomException;
import com.example.XYZ.repository.OrderRepository;
import com.example.XYZ.service.CustomerService;
import com.example.XYZ.service.OrderService;
import com.example.XYZ.service.ProductService;
import com.example.XYZ.service.SellerService;
import com.example.XYZ.vo.CreateOrder;
import com.example.XYZ.vo.OrderVO;
import com.example.XYZ.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @Autowired
    SellerService sellerService;

    @Override
    public OrderVO createOrder(CreateOrder createOrder) throws CustomException {

        Product product = productService.findProductById(createOrder.getProductId());

        BigDecimal totalPrice = new BigDecimal(String.valueOf(product.getPrice().multiply(new BigDecimal(createOrder.getQuantity()))));
        productService.updateProductQuantity(createOrder.getProductId(), createOrder.getQuantity(), '-');

        Order order = new Order();
        order.setCustomerId(createOrder.getCustomerId());
        order.setDate(new Date());
        order.setProductId(createOrder.getProductId());
        order.setTotalPrice(totalPrice);

        order = orderRepository.save(order);
        return getOrderResponse(order);
    }

    @Override
    public OrderVO findOrderByOrderId(Long id) {
        Order order = orderRepository.findOrderByOrderId(id);
        return getOrderResponse(order);
    }

    private OrderVO getOrderResponse(Order order) {
        Product product = productService.findProductById(order.getProductId());
        Customer customer = customerService.findCustomerById(order.getCustomerId());
        Seller seller = sellerService.findSellerById(product.getSellerId());

        ProductVO productVO = new ProductVO()
                .setId(product.getId())
                .setBrandName(product.getBrandName())
                .setCategory(product.getCategory())
                .setColor(product.getColor())
                .setPrice(product.getPrice())
                .setSize(product.getPSize())
                .setSeller(seller);

        return new OrderVO()
                .setOrderId(order.getOrderId())
                .setCustomer(customer)
                .setOrderDate(order.getDate())
                .setPrice(order.getTotalPrice())
                .setProduct(productVO);
    }
}
