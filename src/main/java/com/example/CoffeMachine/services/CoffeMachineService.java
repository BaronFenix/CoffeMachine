package com.example.CoffeMachine.services;

import com.example.CoffeMachine.models.Ingredient;

public interface CoffeMachineService {
    
    public boolean makeCoffee(Long id);
    
    public Ingredient fill(Long id);

    public Iterable<Ingredient> fillAllIngredients();

    public Ingredient updateIngredient(Ingredient ingredien);

    public Iterable<Ingredient> getAllIngredients();

}
