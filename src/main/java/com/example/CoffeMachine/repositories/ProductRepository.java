package com.example.CoffeMachine.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.CoffeMachine.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
    

    @Query(value = "SELECT p.id, p.size, p.price, p.recipe_id, r FROM products p JOIN recipes r ON r.id = p.recipe_id WHERE r.name = :name", nativeQuery = true)
    public Product findByName(@Param("name") String name);
}
