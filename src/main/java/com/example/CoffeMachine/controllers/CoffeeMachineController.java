package com.example.CoffeMachine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CoffeMachine.models.Ingredient;
import com.example.CoffeMachine.services.impl.CoffeeMachineServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class CoffeeMachineController {
    
    @Autowired
    CoffeeMachineServiceImpl coffeeMachineService;

    @GetMapping("/CoffeeMachine/fill")
    public ResponseEntity<String> fillAll() {
        coffeeMachineService.fillAllIngredients();
        return ResponseEntity.ok("Кофемашина заполнена");
    }

    @GetMapping("/CoffeeMachine/editIngredient")
    public ResponseEntity<String> edit(@RequestBody Ingredient ingredient) {
        try {
            coffeeMachineService.updateIngredient(ingredient);
            return ResponseEntity.ok("Данные ингредиента изменены");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Произошла ошибка");
        }
    }

    @GetMapping("/CoffeeMachine/showIngredients")
    public ResponseEntity<Iterable<Ingredient>> show() {
        return ResponseEntity.ok(coffeeMachineService.getAllIngredients());
    }

}
