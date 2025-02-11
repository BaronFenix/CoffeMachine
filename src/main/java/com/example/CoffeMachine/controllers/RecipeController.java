package com.example.CoffeMachine.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.CoffeMachine.dto.RecipeDto;
import com.example.CoffeMachine.models.Recipe;
import com.example.CoffeMachine.services.impl.ProductServiceImpl;

@RestController
public class RecipeController {

    @Autowired
    ProductServiceImpl productService;

    @PostMapping("/recipe/create")
    public ResponseEntity<String> addRecipe(@RequestBody RecipeDto recipeDto) {

        try {
            productService.addRecipe(recipeDto);
            return ResponseEntity.ok("Рецепт успешно добавлен!");
        }
        catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Напиток с данным именем уже имеется");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Произошла ошибка!");
        }
        
    }

    @GetMapping("/recipes/all")
    public ResponseEntity<Iterable<Recipe>> getRecipes() {
        try  {
            Iterable<Recipe> list = productService.getAllRecipes();
            return ResponseEntity.status(HttpStatus.OK).body(list);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(List.of());
        }
    }

}
