package org.exercise.pizza.service;

import java.util.List;

import org.exercise.pizza.dao.IngredientRepository;
import org.exercise.pizza.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    public Ingredient save(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public List<Ingredient> list() {
        return ingredientRepository.findAllByActiveTrue();
    }

    public Ingredient get(Long id) {
        return ingredientRepository.findOne(id);
    }

    public Ingredient add(Ingredient ingredient) {
        Ingredient oldIngredient = ingredientRepository.findOneByName(ingredient.getName());
        if (oldIngredient == null) {
            return save(ingredient);
        } else if (!oldIngredient.isActive()) {
            oldIngredient.setActive(true);
            return save(oldIngredient);
        } else {
            return oldIngredient;
        }
    }

    public Ingredient update(Long id, Ingredient ingredient) {
        Ingredient oldIngredient = get(id);
        oldIngredient.setName(ingredient.getName());
        oldIngredient.setActive(ingredient.getActive());
        return save(oldIngredient);
    }

    public Ingredient disable(Long id) {
        Ingredient ingredient = get(id);
        ingredient.setActive(false);
        return save(ingredient);
    }

}
