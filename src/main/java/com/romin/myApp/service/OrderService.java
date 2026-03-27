package com.romin.myApp.service;

import com.romin.myApp.model.*;
import com.romin.myApp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Order placeOrder(User user, List<Product> products) {

    Order order = new Order();
    order.setUser(user);
    order.setOrderDate(LocalDateTime.now());
    order.setStatus("PLACED");

    BigDecimal total = BigDecimal.ZERO;

    for (Product product : products) {

        OrderItem item = new OrderItem();
        item.setProduct(product);
        item.setQuantity(1);
        item.setPriceAtPurchase(product.getPrice());

        order.addOrderItem(item);   // VERY IMPORTANT
        total = total.add(product.getPrice());
    }

    order.setTotalAmount(total);

    return orderRepository.save(order); // cascade saves items
}
}