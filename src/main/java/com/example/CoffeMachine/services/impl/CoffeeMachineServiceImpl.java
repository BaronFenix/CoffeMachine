package com.example.CoffeMachine.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CoffeMachine.models.Ingredient;
import com.example.CoffeMachine.models.Recipe;
import com.example.CoffeMachine.repositories.IngredientRepository;
import com.example.CoffeMachine.repositories.RecipeRepository;
import com.example.CoffeMachine.services.CoffeMachineService;

@Service
public class CoffeeMachineServiceImpl implements CoffeMachineService {

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    RecipeRepository recipeRepository;

	@Override
	public boolean makeCoffee(Long id) {
        Recipe recipe = recipeRepository.findById(id).get();
        Iterable<Ingredient> ingredients = ingredientRepository.findAll();

        if (!checkAvailability(ingredients, recipe)) {
            return false;
        }

        for(Ingredient elem : ingredients) {
            Double storage = elem.getValue();
            
            switch (elem.getName().toLowerCase()) {
                case "кофе":
                    elem.setValue(storage -= recipe.getCoffee());
                    break;
                case "молоко":
                    elem.setValue(storage -= recipe.getMilk());
                    break;
                case "вода":
                    elem.setValue(storage -= recipe.getWater());
                    break;
                default:
                    break;
            }
        }
        ingredientRepository.saveAll(ingredients);
        return true;
	}

    private boolean checkAvailability (Iterable<Ingredient> ingredients, Recipe recipe) {
        for(Ingredient elem : ingredients) {
            Double storage = elem.getValue();
            switch (elem.getName().toLowerCase()) {
                case "кофе":
                    if ((storage -= recipe.getCoffee()) < 0) {
                        return false;
                    } 
                    break;                 
                case "молоко":
                    if ((storage -= recipe.getMilk()) < 0) {
                        return false;
                    } 
                    break;                  
                case "вода":
                    if ((storage -= recipe.getWater()) < 0) {
                        return false;
                    } 
                    break;                   
                default:
                    break;
            }
        }
        return true;
    }

	@Override
	public Ingredient fill(Long id) {
		Ingredient ingredient = ingredientRepository.findById(id).get();
        ingredient.setValue(ingredient.getMaxLimit());

        return updateIngredient(ingredient);
	}

	@Override
	public Iterable<Ingredient> fillAllIngredients() {
		Iterable<Ingredient> list = ingredientRepository.findAll();
        list.forEach(x -> x.setValue(x.getMaxLimit()));
        
        return ingredientRepository.saveAll(list);
    }

	@Override
	public Ingredient updateIngredient(Ingredient ingredient) {
		return ingredientRepository.save(ingredient);
	}

    @Override
    public Iterable<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }


}
