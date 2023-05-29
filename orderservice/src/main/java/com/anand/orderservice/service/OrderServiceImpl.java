package com.anand.orderservice.service;

import com.anand.orderservice.model.Order;
import com.anand.orderservice.model.OrderRequest;
import com.anand.orderservice.repository.OrderRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public long placeOrder(OrderRequest orderRequest) {
        // Order Entity - Save the data with order status created.
        //Product Service - Block Products to reduce the available quantity.
        // Payment Service - Make Payment and mark payment status.
        log.info("Placing order request{}"+orderRequest);
        Order order = Order.builder()
                .amount(orderRequest.getTotalAmount())
                .orderStatus("CREATED")
                .orderDate(Instant.now())
                .quantity(orderRequest.getQuantity())
                .productId(orderRequest.getProductId()).build();
        order = orderRepository.save(order);
        log.info("Order placed successfully with order id:"+order.getId());
        return order.getId();
    }
}
