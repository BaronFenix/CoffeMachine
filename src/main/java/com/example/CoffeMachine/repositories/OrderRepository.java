package com.example.CoffeMachine.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.CoffeMachine.models.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
    
    @Query(value = "SELECT r.id from orders o " + 
                    "JOIN products p ON o.product_id = p.id " + 
                    "JOIN recipes r ON p.recipe_id = r.id " + 
                    "GROUP BY r.id " + 
                    "ORDER BY SUM(o.quantity) DESC " + 
                    "LIMIT 1", nativeQuery = true)
    public Long findMostPopularProduct();

}
