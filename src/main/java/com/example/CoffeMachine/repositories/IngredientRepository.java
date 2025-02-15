package com.example.CoffeMachine.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.CoffeMachine.models.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
    

}
