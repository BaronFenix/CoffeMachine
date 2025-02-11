package com.example.CoffeMachine.services;

import com.example.CoffeMachine.models.Order;
import com.example.CoffeMachine.models.Product;

public interface OrderService {

    public Order addOrder(Product coffee);

    public Long getMostPopularProduct();
}
