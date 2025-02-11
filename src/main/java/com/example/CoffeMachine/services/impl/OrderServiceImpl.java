package com.example.CoffeMachine.services.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CoffeMachine.models.Order;
import com.example.CoffeMachine.models.Product;
import com.example.CoffeMachine.repositories.OrderRepository;
import com.example.CoffeMachine.services.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
    
    @Autowired
    OrderRepository orderRepository;
    
    @Override
    public Order addOrder(Product coffee) {
        int quantity = 1;
        Order order = new Order(LocalDateTime.now(), quantity, coffee);
        
        orderRepository.save(order);

        return order;
    }

    @Override
    public Long getMostPopularProduct() {
        return orderRepository.findMostPopularProduct();
    }

    
}
