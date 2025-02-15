package com.example.CoffeMachine.controllers;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.CoffeMachine.models.Product;
import com.example.CoffeMachine.models.Recipe;
import com.example.CoffeMachine.services.impl.CoffeeMachineServiceImpl;
import com.example.CoffeMachine.services.impl.HolidayServiceImpl;
import com.example.CoffeMachine.services.impl.OrderServiceImpl;
import com.example.CoffeMachine.services.impl.ProductServiceImpl;

@RestController
public class OrderController {

    @Autowired
    OrderServiceImpl orderService;

    @Autowired
    ProductServiceImpl productService;

    @Autowired
    HolidayServiceImpl holidayService;

    @Autowired
    CoffeeMachineServiceImpl coffeeMachineService;

    @PostMapping("/order/create")
    public ResponseEntity<String> makeOrder(@RequestBody String coffeeName) {

        Product product = productService.getByName(coffeeName).get();
        try {
            if(holidayService.isWorking()) {
                if(!coffeeMachineService.makeCoffee(product.getId())) {
                    return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Недостаточно ингредиентов! заказ отменен");
                }
                orderService.addOrder(product);
                
                return ResponseEntity.ok("Заказ успешно выполнен!");
            }
            else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Аппарат не работает. \\nРабочее время: с 8:00 до 17:00 (будние дни)");
            }
        }
        catch(NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Продукт не найден");
        }
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

    @GetMapping("/order/is-work")
    public ResponseEntity<Boolean> isWork() {

        return ResponseEntity.ok(holidayService.isWorking());
    }

}
