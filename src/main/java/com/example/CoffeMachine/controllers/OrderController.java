package com.example.CoffeMachine.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.CoffeMachine.models.Product;
import com.example.CoffeMachine.models.Recipe;
import com.example.CoffeMachine.services.impl.OrderServiceImpl;
import com.example.CoffeMachine.services.impl.ProductServiceImpl;

@RestController
public class OrderController {

    @Autowired
    OrderServiceImpl orderService;

    @Autowired
    ProductServiceImpl productService;

    @PostMapping("/order/create")
    public String addOrder(@RequestBody String coffeeName) {
        
        String message;

        Optional<Product> product = productService.getByName(coffeeName);
        if(product.isPresent()) {
            orderService.addOrder(product.get());
            message = "Заказ успешно выполнен!";
        }
        else {
            message = "Продукт не найден!";
        }

        return message;
    }

    @GetMapping("/statistics/popular")
    public ResponseEntity<String> popularRecipe() {
        
        try {
            Long id = orderService.getMostPopularProduct();
            Recipe recipe = productService.getRecipeById(id).get();
            return ResponseEntity.ok(recipe.getName());
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Произошла ошибка!");
        }
    }

}
