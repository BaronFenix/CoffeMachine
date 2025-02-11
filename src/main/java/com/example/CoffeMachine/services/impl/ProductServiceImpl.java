package com.example.CoffeMachine.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CoffeMachine.dto.RecipeDto;
import com.example.CoffeMachine.models.Product;
import com.example.CoffeMachine.models.Recipe;
import com.example.CoffeMachine.repositories.ProductRepository;
import com.example.CoffeMachine.repositories.RecipeRepository;
import com.example.CoffeMachine.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    RecipeRepository recipeRepository;

    @Override
    public Recipe addRecipe(RecipeDto recipeDto) {
        Recipe recipe = new Recipe(recipeDto.getName(), recipeDto.getCoffee(), recipeDto.getMilk(), recipeDto.getWater());
        Recipe savedRecipe = recipeRepository.save(recipe);

        addProduct(new Product(recipeDto.getSize(), recipeDto.getPrice(), savedRecipe));

        return savedRecipe;
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
    
    @Override
    public Optional<Product> getByName(String name) {
        try {
            return Optional.of(productRepository.findByName(name));
        }
        catch(NullPointerException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Recipe> getRecipeById(Long id) {
        return recipeRepository.findById(id);
    }

    public Iterable<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }
}
