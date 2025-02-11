package com.example.CoffeMachine.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.CoffeMachine.models.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    
}
