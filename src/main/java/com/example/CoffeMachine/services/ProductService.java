package com.example.CoffeMachine.services;

import java.util.Optional;

import com.example.CoffeMachine.dto.RecipeDto;
import com.example.CoffeMachine.models.Product;
import com.example.CoffeMachine.models.Recipe;

public interface ProductService {

    public Recipe addRecipe(RecipeDto recipeDto);

    public Optional<Recipe> getRecipeById(Long id);
    
    public Iterable<Recipe> getAllRecipes();

    public Product addProduct(Product product);

    public Optional<Product> getByName(String name);


    
}
